package com.recap.lovable_clone.repositories;

import com.recap.lovable_clone.dto.member.MemberResponse;
import com.recap.lovable_clone.entity.ProjectMember;
import com.recap.lovable_clone.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember , ProjectMemberId> {
    List<ProjectMember> findByIdProjectId(Long projectId);
}
