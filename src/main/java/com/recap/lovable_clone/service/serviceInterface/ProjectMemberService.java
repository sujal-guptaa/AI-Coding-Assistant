package com.recap.lovable_clone.service.serviceInterface;

import com.recap.lovable_clone.dto.member.InviterMemberRequest;
import com.recap.lovable_clone.dto.member.MemberResponse;
import com.recap.lovable_clone.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);
    MemberResponse inviteMember(Long projectId, InviterMemberRequest request);
    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);
    void removeProjectMember(Long projectId, Long memberId);
}
