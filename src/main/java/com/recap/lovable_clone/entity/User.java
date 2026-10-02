package com.recap.lovable_clone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    Long id;
    @Column(unique = true,nullable = false)
    String email;
    String passwordHash;
    @Column(nullable = false)
    String name;
    String avatarUrl;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}
