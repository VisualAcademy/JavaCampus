package com.hawaso.javacampus.repositories.identity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hawaso.javacampus.models.identity.AspNetRole;

public interface AspNetRoleRepository extends JpaRepository<AspNetRole, String> {
    Optional<AspNetRole> findByNormalizedName(String normalizedName);
}
