package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.auth.AuthResponse;
import com.recap.lovable_clone.dto.auth.LoginRequest;
import com.recap.lovable_clone.dto.auth.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthResponse signUp(SignUpRequest request);
    AuthResponse login(LoginRequest request);
}
