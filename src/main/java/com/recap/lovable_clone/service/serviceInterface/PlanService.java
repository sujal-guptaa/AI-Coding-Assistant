package com.recap.lovable_clone.service.serviceInterface;

import com.recap.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
