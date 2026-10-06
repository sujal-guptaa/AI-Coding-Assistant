package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.project.ProjectRequest;
import com.recap.lovable_clone.dto.project.ProjectResponse;
import com.recap.lovable_clone.dto.project.ProjectSummaryResponse;
import com.recap.lovable_clone.entity.Project;
import com.recap.lovable_clone.entity.User;
import com.recap.lovable_clone.mapper.ProjectMapper;
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
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper mapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        project=projectRepository.save(project);
        return mapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//            return projectRepository.findAllAccessibleByUser(userId)
//                .stream().map(mapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());
        var projects=projectRepository.findAllAccessibleByUser(userId);
        return mapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id ,Long userId) {
        Project project= getAccessibleProjectById(id,userId);
        return mapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project=getAccessibleProjectById(id,userId);
        project.setName(request.name());
        project=projectRepository.save(project);
        return mapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project=getAccessibleProjectById(id,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw  new RuntimeException("You are not allowed to delete");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // Internal Functions
    public Project getAccessibleProjectById(Long projectId, Long userId){

        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }
}
