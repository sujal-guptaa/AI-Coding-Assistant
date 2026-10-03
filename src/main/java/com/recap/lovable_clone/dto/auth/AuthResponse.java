package com.recap.lovable_clone.dto.auth;

public record AuthResponse (
        String token,
        UserProfileResponse user
){
}
