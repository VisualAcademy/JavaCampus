package com.hawaso.javacampus.repositories.campus;

import java.util.List;

import com.hawaso.javacampus.models.campus.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 생략 가능 
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Select * From Students Where FirstName = ? 
    List<Student> findByFirstName(String firstName);
    
    // Select * From Students Where FirstName = ? And LastName = ?
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    
    // Select * From Students Where Upper(FirstName) = Upper(?)
    List<Student> findByFirstNameIgnoreCase(String string);
}
