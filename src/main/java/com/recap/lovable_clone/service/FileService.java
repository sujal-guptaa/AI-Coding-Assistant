package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.Files.FileContentResponse;
import com.recap.lovable_clone.dto.Files.FileNode;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FileService {
    FileContentResponse getFileContent(Long projectId, String path, Long userId);
    List<FileNode> getFileTree(Long projectId, Long userId);
}
