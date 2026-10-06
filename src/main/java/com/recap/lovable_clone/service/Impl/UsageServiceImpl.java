package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.recap.lovable_clone.dto.subscription.UsageTodayResponse;
import com.recap.lovable_clone.service.serviceInterface.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId) {
        return null;
    }
}
