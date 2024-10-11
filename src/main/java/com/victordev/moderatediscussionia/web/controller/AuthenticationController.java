package com.victordev.moderatediscussionia.web.controller;

import com.victordev.moderatediscussionia.dto.security.LoginRequest;
import com.victordev.moderatediscussionia.dto.security.LoginResponse;
import com.victordev.moderatediscussionia.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll()")
    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse>authenticate(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/logout")
    public void logout() throws Exception{
        authenticationService.logout();
    }
}