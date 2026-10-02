package com.recap.lovable_clone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {
    @Id
    Long id;
    User owner;//TODO:
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    Boolean isPublic=false;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;//soft delete
}
