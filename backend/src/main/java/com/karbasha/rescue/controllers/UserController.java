package com.karbasha.rescue.controllers;

import com.karbasha.rescue.services.*;
import com.karbasha.rescue.dtos.user.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('user')")
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserProfileResponse getUser(KeycloakAuthenticationToken principal) {
        return userService.getUserOrCreate(principal.getName(), principal.getAccount().getKeycloakSecurityContext().getToken());
    }
}
