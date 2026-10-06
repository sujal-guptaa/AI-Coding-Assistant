package com.recap.lovable_clone.service.serviceInterface;

import com.recap.lovable_clone.dto.auth.AuthResponse;
import com.recap.lovable_clone.dto.auth.LoginRequest;
import com.recap.lovable_clone.dto.auth.SignUpRequest;


public interface AuthService {
    AuthResponse signUp(SignUpRequest request);
    AuthResponse login(LoginRequest request);
}
