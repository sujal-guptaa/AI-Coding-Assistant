package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.subscription.PlanResponse;
import com.recap.lovable_clone.service.serviceInterface.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
