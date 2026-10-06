package com.recap.lovable_clone.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true,nullable = false)
    String email;

//    @Column(nullable = false)
    String passwordHash;

    @Column(nullable = false)
    String name;

    String avatarUrl;

//    @CreationTimestamp
    Instant createdAt;

//    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;//soft delete
}
