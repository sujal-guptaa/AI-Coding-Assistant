package com.recap.lovable_clone.dto.subscription;

public record UsageTodayResponse(
        int tokenUsed,
        int tokenLimit,
        int previewRunning,
        int previewLimit
) {
}
