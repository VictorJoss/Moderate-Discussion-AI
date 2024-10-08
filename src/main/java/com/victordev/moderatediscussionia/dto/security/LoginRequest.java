package com.victordev.moderatediscussionia.dto.security;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank String username,
        @NotBlank String password
)
{}
