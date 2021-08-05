package team.healthtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import team.healthtech.db.provider.UserSecurityProvider;
import team.healthtech.handler.HealthtechAccessDeniedHandler;
import team.healthtech.handler.HealthtechFailureHandler;
import team.healthtech.handler.HealthtechSuccessHandler;
import team.healthtech.impl.UserDetailsServiceImpl;
import team.healthtech.service.security.ProfileMapper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserSecurityProvider userSecurityProvider;
    private final ProfileMapper profileMapper;

    @Autowired
    public SecurityConfiguration(
        UserSecurityProvider userSecurityProvider,
        ProfileMapper profileMapper
    ) {
        this.userSecurityProvider = userSecurityProvider;
        this.profileMapper = profileMapper;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean());
        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        auth.authenticationProvider(daoAuthenticationProvider);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(userSecurityProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().disable()
            .csrf().disable()
            .logout()
            .logoutUrl("/user/logout")
            .and()
            .formLogin()
            .loginProcessingUrl("/user/login")
            .successHandler(new HealthtechSuccessHandler(userSecurityProvider, profileMapper))
            .failureHandler(new HealthtechFailureHandler())

            .and()
            .authorizeRequests()
            .mvcMatchers(HttpMethod.POST, "/user/login").not().authenticated()
            .anyRequest().permitAll()/*.fullyAuthenticated()*/
            .and()
            .exceptionHandling().accessDeniedHandler(new HealthtechAccessDeniedHandler())
        ;
    }

}
