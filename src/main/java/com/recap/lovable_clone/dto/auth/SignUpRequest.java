package com.recap.lovable_clone.dto.auth;

public record SignUpRequest(
        String email,
        String password,
        String name
) {
}
