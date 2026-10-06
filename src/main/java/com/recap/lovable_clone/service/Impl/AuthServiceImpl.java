package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.auth.AuthResponse;
import com.recap.lovable_clone.dto.auth.LoginRequest;
import com.recap.lovable_clone.dto.auth.SignUpRequest;
import com.recap.lovable_clone.service.serviceInterface.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signUp(SignUpRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
