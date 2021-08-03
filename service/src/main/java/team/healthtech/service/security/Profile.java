package team.healthtech.service.security;

import org.immutables.value.Value;
import team.healthtech.common.Role;

@Value.Immutable
public interface Profile {

    Integer getId();
    String getLogin();
    String getEmail();
    Role getRole();

}
