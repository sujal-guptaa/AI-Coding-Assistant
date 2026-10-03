package com.recap.lovable_clone.dto.subscription;

public record PlanResponse(
        Long Id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Boolean unlimitedAi,
        String price
) {
}
