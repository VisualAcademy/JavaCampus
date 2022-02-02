package com.hawaso.javacampus.repositories.campus;

import com.hawaso.javacampus.models.campus.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
