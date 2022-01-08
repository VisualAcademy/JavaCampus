package com.hawaso.javacampus.repositories.shirts;

import com.hawaso.javacampus.models.shirts.Shirt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
    // Empty
}
