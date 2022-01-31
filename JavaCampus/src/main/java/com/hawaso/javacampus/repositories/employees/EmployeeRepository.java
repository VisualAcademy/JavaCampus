package com.hawaso.javacampus.repositories.employees;

import java.util.List;

import com.hawaso.javacampus.models.employees.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이미 CrudRepository를 상속하기에 생략해도 되지만, 명확하게 리포지토리 클래스를 표현하기 위해서
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByOrderByIdDesc(); 
    public List<Employee> findByOrderByFirstNameAsc(); 
    public List<Employee> findAllByOrderByLastNameAsc(); 
    public List<Employee> findByFirstNameContainsOrLastNameContainingIgnoreCase(String firstName, String lastName); 
}
