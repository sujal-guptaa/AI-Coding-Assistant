package com.recap.lovable_clone.entity;

import java.time.Instant;

public class UsageLog {
    Long id;
    User user;
    Project project;
    String action;
    Integer tokenUsed;
    Integer duration;
    String metadata;
    Instant createdAt;
}
