package com.recap.lovable_clone.dto.member;

import com.recap.lovable_clone.enums.ProjectRole;

public record InviterMemberRequest(
        String email,
        ProjectRole role
) {
}
