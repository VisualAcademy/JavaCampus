package com.hawaso.javacampus.repositories.campus;

import com.hawaso.javacampus.models.campus.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 참고: @Repository 애너테이션은 넣을 필요없음 
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
