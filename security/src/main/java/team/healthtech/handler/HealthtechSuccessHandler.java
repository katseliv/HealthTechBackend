package team.healthtech.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import team.healthtech.db.provider.UserSecurityProvider;
import team.healthtech.service.security.ProfileMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HealthtechSuccessHandler implements AuthenticationSuccessHandler {

    private final UserSecurityProvider userProvider;
    private final ProfileMapper profileMapper;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public HealthtechSuccessHandler(UserSecurityProvider userProvider, ProfileMapper profileMapper) {
        this.userProvider = userProvider;
        this.profileMapper = profileMapper;
    }

    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication
    ) throws IOException, ServletException {
        var profile = profileMapper.toProfile(
            userProvider.findByLogin(authentication.getName()));

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(200);
        OBJECT_MAPPER.writeValue(response.getWriter(), profile);
    }

}
