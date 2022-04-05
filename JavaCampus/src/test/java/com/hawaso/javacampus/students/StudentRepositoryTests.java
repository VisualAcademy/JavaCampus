package com.hawaso.javacampus.students;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
        //[0] 처음 데이터 입력
        final Student student = new Student();

        student.setFirstName("YJ");
        student.setLastName("Park");

        _repository.save(student);

        //[1] 1개의 데이터 저장 테스트 
        assertEquals(1, _repository.findAll().size());

        //[3] 파생 쿼리 테스트
        //[3][1] 이름만 테스트
        List<Student> students1 = _repository.findByFirstName("YJ");
        assertEquals(1, students1.size());

        //[3][2] 이름과 성 모두 테스트 
        List<Student> students2 = 
            _repository.findByFirstNameAndLastName("YJ", "Kim");
        assertEquals(0, students2.size());

        //[3][3] 대소문자 구분
        List<Student> students3 = _repository.findByFirstName("yj");
        assertEquals(0, students3.size()); // YJ가 아닌 yj는 못 찾음
        List<Student> students4 = _repository.findByFirstNameIgnoreCase("yj");
        assertEquals(1, students4.size()); // YJ가 아닌 yj는 못 찾음

        //[2] 현재 데이터 삭제
        _repository.deleteById(student.getId());
        assertEquals(0L, _repository.count());
    }
}
