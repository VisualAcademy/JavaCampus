package com.hawaso.javacampus.repositories.identity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hawaso.javacampus.models.identity.AspNetUserRole;
import com.hawaso.javacampus.models.identity.AspNetUserRoleId;

public interface AspNetUserRoleRepository extends JpaRepository<AspNetUserRole, AspNetUserRoleId> {
    List<AspNetUserRole> findByUserId(String userId);
    boolean existsByUserIdAndRoleId(String userId, String roleId);
}
