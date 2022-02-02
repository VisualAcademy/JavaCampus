package com.hawaso.javacampus.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hawaso.javacampus.models.campus.Student;
import com.hawaso.javacampus.repositories.campus.StudentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTests {
    @Autowired
    private StudentRepository _repository; 

    @Test
    public void getAllTest() {
        final Student student = new Student();

        student.setFirstName("YJ");
        student.setLastName("Park");

        // 처음 데이터 입력
        _repository.save(student);

        assertEquals(1, _repository.findAll().size());

        // 현재 데이터 삭제
        _repository.deleteById(student.getId());

        assertEquals(0L, _repository.count());
    }
}
