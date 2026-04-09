package com.hawaso.javacampus.repositories.campus;

import com.hawaso.javacampus.models.campus.Enrollment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    
}
