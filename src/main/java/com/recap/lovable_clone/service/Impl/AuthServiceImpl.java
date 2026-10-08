package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.auth.AuthResponse;
import com.recap.lovable_clone.dto.auth.LoginRequest;
import com.recap.lovable_clone.dto.auth.SignUpRequest;
import com.recap.lovable_clone.entity.User;
import com.recap.lovable_clone.error.BadRequestException;
import com.recap.lovable_clone.mapper.UserMapper;
import com.recap.lovable_clone.repositories.UserRepository;
import com.recap.lovable_clone.service.serviceInterface.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse signUp(SignUpRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
                    throw new BadRequestException("User already exist with username: "+request.username());
        });
        User user=userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user=userRepository.save(user);
        return new AuthResponse("dummy",userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
