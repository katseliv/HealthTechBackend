package team.healthtech.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import team.healthtech.service.security.Profile;

@Configuration
public class CurrentUserConfiguration {

    @Bean
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    public Profile getProfile() {
        var authentication = SecurityContextHolder
            .getContext()
            .getAuthentication();

        if (authentication == null) {
            return null;
        }
        var principal = authentication.getPrincipal();

        if (principal instanceof Profile) {
            return (Profile) principal;
        }
        return null;
    }

}
