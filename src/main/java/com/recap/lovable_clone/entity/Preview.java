package com.recap.lovable_clone.entity;

import com.recap.lovable_clone.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {
    Long id;
    Project projectId;
    String nameSpace;
    String podName;
    String previewUrl;
    PreviewStatus Status; //TODO: Make Enum
    Instant startedAt;
    Instant terminatedAt;
    Instant createdAt;
}
