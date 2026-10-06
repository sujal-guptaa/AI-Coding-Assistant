package com.recap.lovable_clone.service.serviceInterface;

import com.recap.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.recap.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId);
}
