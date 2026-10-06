package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.auth.UserProfileResponse;
import com.recap.lovable_clone.service.serviceInterface.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
