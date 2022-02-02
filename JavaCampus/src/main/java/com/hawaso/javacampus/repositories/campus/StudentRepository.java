package com.hawaso.javacampus.repositories.campus;

import com.hawaso.javacampus.models.campus.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
