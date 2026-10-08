package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.project.ProjectRequest;
import com.recap.lovable_clone.dto.project.ProjectResponse;
import com.recap.lovable_clone.dto.project.ProjectSummaryResponse;
import com.recap.lovable_clone.entity.Project;
import com.recap.lovable_clone.entity.ProjectMember;
import com.recap.lovable_clone.entity.ProjectMemberId;
import com.recap.lovable_clone.entity.User;
import com.recap.lovable_clone.enums.ProjectRole;
import com.recap.lovable_clone.error.ResourceNotFoundException;
import com.recap.lovable_clone.mapper.ProjectMapper;
import com.recap.lovable_clone.repositories.ProjectMemberRepository;
import com.recap.lovable_clone.repositories.ProjectRepository;
import com.recap.lovable_clone.repositories.UserRepository;
import com.recap.lovable_clone.service.serviceInterface.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper mapper;
    ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User",userId.toString())
        );
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project = projectRepository.save(project);
        ProjectMemberId projectMemberId=new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember=ProjectMember.builder()
                .id(projectMemberId )
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .project(project)
                .invitedAt(Instant.now())
                .acceptedAt(Instant.now())
                .build();
        projectMemberRepository.save(projectMember);
        return mapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//            return projectRepository.findAllAccessibleByUser(userId)
//                .stream().map(mapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return mapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return mapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return mapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // Internal Functions
    public Project getAccessibleProjectById(Long projectId, Long userId) {

        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString())
                );
    }
}
