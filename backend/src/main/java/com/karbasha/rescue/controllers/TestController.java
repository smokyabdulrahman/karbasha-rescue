package com.karbasha.rescue.controllers;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @PreAuthorize("hasRole('user')")
    @GetMapping(path = "/customers")
    public String customers(KeycloakAuthenticationToken principal) {
        principal.getName();
        return "customers";
    }
}
