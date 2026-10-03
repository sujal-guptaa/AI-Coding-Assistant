package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.project.ProjectRequest;
import com.recap.lovable_clone.dto.project.ProjectResponse;
import com.recap.lovable_clone.dto.project.ProjectSummaryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);
    ProjectResponse getUserProjectById(Long userId);
    ProjectResponse createProject(ProjectRequest request, Long userId);
    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);
    void softDelete(Long id, Long userId);
}
