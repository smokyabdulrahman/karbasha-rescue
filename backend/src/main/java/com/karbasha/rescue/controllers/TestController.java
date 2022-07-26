package com.karbasha.rescue.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @PreAuthorize("hasRole('user')")
    @GetMapping(path = "/customers")
    public String customers(Principal principal) {
        principal.getName();
        return "customers";
    }
}
