package com.recap.lovable_clone.controller;

import com.recap.lovable_clone.dto.Files.FileContentResponse;
import com.recap.lovable_clone.dto.Files.FileNode;
import com.recap.lovable_clone.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
    }
    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    ){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId,path,userId));
    }
}
