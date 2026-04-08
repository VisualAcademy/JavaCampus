package com.hawaso.javacampus.models.employees;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employees")
public class Employee {
    // 필드
    @Id 
    @GeneratedValue // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @NotBlank(message = "FirstName을 입력하세요.")
    @Column(name = "FirstName")
    @Size(min = 2, max = 10)
    private String firstName;
    
    @NotBlank(message = "LastName을 입력하세요.")
    @Column(name = "LastName")
    private String lastName;
    
    @NotBlank(message = "Role을 입력하세요.")
    @Column(name = "Role")
    private String role;

    // 생성자
    public Employee() {
        // Empty
    }

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    // 게터와 세터 
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }        

    public String getName() {
        return this.firstName + " " + this.lastName;
    }
    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return this.role;
    }    
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee model = (Employee) o;
        return 
            Objects.equals(this.id, model.id) 
            && 
            Objects.equals(this.firstName, model.firstName)
            && 
            Objects.equals(this.lastName, model.lastName) 
            && 
            Objects.equals(this.role, model.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.role);
    }

    // ToString 메서드 오버라이드 
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", firstName='" 
        + this.firstName + '\'' + ", lastName='" + this.lastName
        + '\'' + ", role='" + this.role + '\'' + '}';
    }
}
