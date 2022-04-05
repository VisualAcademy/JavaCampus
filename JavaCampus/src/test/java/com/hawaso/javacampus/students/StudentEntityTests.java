package com.hawaso.javacampus.students;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hawaso.javacampus.models.campus.Student;
import com.hawaso.javacampus.repositories.campus.StudentRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class StudentEntityTests {
    @Autowired
    private EntityManager entityManager; 

    @Test
    public void studentAddTestWithEntityManager() {
        final Student student = new Student();
        student.setFirstName("YJ");
        student.setLastName("Park");
        student.setEmail("a@a.com");

        entityManager.persist(student);

        final TypedQuery<Student> query = 
            entityManager.createQuery("SELECT s FROM Student s", Student.class);

        final List<Student> students = query.getResultList();

        Assertions.assertThat(students).hasSize(1).first().isEqualTo(student);
    }     

    @Autowired
    private StudentRepository studentRepository;

    @Test 
    public void studentCrudTest() {
        final Student student = new Student();
        student.setFirstName("YJ");
        student.setLastName("Park");
        student.setEmail("a@a.com");

        // 입력
        studentRepository.save(student); 

        // 확인
        Assertions.assertThat(studentRepository.findAll())
            .hasSize(1)
            .first()
            .isEqualTo(student);

        // 삭제
        studentRepository.deleteById(student.getId());

        // 개수
        Assertions.assertThat(studentRepository.count()).isZero(); 
    }
}
