package com.hawaso.javacampus.repositories.identity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hawaso.javacampus.models.identity.AspNetUser;

public interface AspNetUserRepository extends JpaRepository<AspNetUser, String> {
    Optional<AspNetUser> findByNormalizedUserName(String normalizedUserName);
    Optional<AspNetUser> findByNormalizedEmail(String normalizedEmail);
}
