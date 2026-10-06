package com.recap.lovable_clone.service.serviceInterface;

import com.recap.lovable_clone.dto.Files.FileContentResponse;
import com.recap.lovable_clone.dto.Files.FileNode;

import java.util.List;
public interface FileService {
    FileContentResponse getFileContent(Long projectId, String path, Long userId);
    List<FileNode> getFileTree(Long projectId, Long userId);
}
