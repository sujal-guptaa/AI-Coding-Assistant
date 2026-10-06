package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.member.InviterMemberRequest;
import com.recap.lovable_clone.dto.member.MemberResponse;
import com.recap.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.recap.lovable_clone.entity.Project;
import com.recap.lovable_clone.entity.ProjectMember;
import com.recap.lovable_clone.entity.ProjectMemberId;
import com.recap.lovable_clone.entity.User;
import com.recap.lovable_clone.mapper.ProjectMemberMapper;
import com.recap.lovable_clone.repositories.ProjectMemberRepository;
import com.recap.lovable_clone.repositories.ProjectRepository;
import com.recap.lovable_clone.repositories.UserRepository;
import com.recap.lovable_clone.service.serviceInterface.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);
        List<MemberResponse> memberResponseList=new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));
        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList()
        );

        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviterMemberRequest request, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);
        if (!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }
        User invitee=userRepository.findByEmail(request.email()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId , invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite once again");
        }
        ProjectMember projectMember=ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .invitedAt(Instant.now())
                .user(invitee)
                .projectRole(request.role())
                .build();
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);
        if (!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember=projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);
        if (!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }

    // Internal Functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }
}
