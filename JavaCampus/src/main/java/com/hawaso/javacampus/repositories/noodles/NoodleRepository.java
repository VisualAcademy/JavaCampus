package com.hawaso.javacampus.repositories.noodles;

import com.hawaso.javacampus.models.buffet.Noodle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoodleRepository extends JpaRepository<Noodle, Integer> {
    
}
