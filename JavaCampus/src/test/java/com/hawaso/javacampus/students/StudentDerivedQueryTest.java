package com.hawaso.javacampus.students;

import java.util.List;

import com.hawaso.javacampus.models.campus.Student;
import com.hawaso.javacampus.repositories.campus.StudentRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDerivedQueryTest {
    @Autowired
    private StudentRepository _repository;
   
    @Test 
    public void derivedQueryTest() {
        final Student student1 = new Student();
        student1.setFirstName("YJ");
        student1.setLastName("Park");
        student1.setEmail("a@a.com");

        final Student student2 = new Student();
        student2.setFirstName("Red");
        student2.setLastName("Plus");
        student2.setEmail("r@r.com");

        // 입력
        _repository.save(student1);  
        _repository.save(student2);  

        // 파생 쿼리 메서드 테스트
        List<Student> students = _repository.findByEmail("r@r.com");

        Assertions.assertThat(students).hasSize(1);
    }
}
