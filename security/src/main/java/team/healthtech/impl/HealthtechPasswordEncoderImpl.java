package team.healthtech.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import team.healthtech.service.security.HealthtechPasswordEncoder;

public class HealthtechPasswordEncoderImpl implements HealthtechPasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public HealthtechPasswordEncoderImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
