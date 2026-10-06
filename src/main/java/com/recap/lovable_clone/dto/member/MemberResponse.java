package com.recap.lovable_clone.dto.member;

import com.recap.lovable_clone.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String name,
        String email,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
