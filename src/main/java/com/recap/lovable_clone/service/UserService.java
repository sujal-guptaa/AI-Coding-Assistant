package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.auth.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
