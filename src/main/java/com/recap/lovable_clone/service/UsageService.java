package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.recap.lovable_clone.dto.subscription.UsageTodayResponse;
import org.springframework.stereotype.Service;

@Service
public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId);
}
