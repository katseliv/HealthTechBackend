package team.healthtech.service.security;

import org.immutables.value.Value;

@Value.Immutable
public interface Profile {

    Integer getId();
    String getLogin();
    String getEmail();

}
