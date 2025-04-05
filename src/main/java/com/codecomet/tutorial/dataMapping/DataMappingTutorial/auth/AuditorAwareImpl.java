package com.codecomet.tutorial.dataMapping.DataMappingTutorial.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        //get the security context
//        get the authentication
//        get the principle
//        get the username
        return Optional.of("Sankalp Pal");
    }
}
