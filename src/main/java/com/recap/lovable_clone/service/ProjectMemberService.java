package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.member.InviterMemberRequest;
import com.recap.lovable_clone.dto.member.MemberResponse;
import com.recap.lovable_clone.entity.ProjectMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberService {
    List<ProjectMember> getProjectMembers(Long projectId, Long userId);
    MemberResponse inviteMember(Long projectId, InviterMemberRequest request, Long userId);
    MemberResponse updateMemberRole(Long projectId, Long memberId, InviterMemberRequest request, Long userId);
    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
