package com.recap.lovable_clone.dto.member;

import com.recap.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviterMemberRequest(
        @Email @NotBlank
        String username,
        @NotNull
        ProjectRole role
) {
}
