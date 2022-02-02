package com.hawaso.javacampus.repositories.campus;

import com.hawaso.javacampus.models.campus.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 생략 가능 
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
