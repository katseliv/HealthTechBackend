package team.healthtech.impl;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.common.Role;
import team.healthtech.service.security.Profile;

@Service
public class UserAuthService {

    private final ObjectProvider<Profile> profileProvider;

    @Autowired
    public UserAuthService(ObjectProvider<Profile> profileProvider) {
        this.profileProvider = profileProvider;
    }

    public boolean canUpdateUser(int id) {
        final var profile = profileProvider.getIfAvailable();
        if (profile == null) {
            return false;
        }
        if (profile.getRole() == Role.ADMIN) {
            return true;
        }

        return profile.getId() == id; // users can update themselves
    }
}
