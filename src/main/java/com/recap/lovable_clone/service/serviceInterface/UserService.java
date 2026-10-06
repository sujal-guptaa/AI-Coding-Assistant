package com.recap.lovable_clone.service.serviceInterface;

import com.recap.lovable_clone.dto.auth.UserProfileResponse;


public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
