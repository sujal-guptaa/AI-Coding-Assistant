package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.Files.FileContentResponse;
import com.recap.lovable_clone.dto.Files.FileNode;
import com.recap.lovable_clone.service.serviceInterface.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }

    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }
}
