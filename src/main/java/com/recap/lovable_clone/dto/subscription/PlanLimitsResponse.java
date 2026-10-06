package com.recap.lovable_clone.dto.subscription;

import jakarta.persistence.criteria.CriteriaBuilder;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
