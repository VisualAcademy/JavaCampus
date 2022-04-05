package com.hawaso.javacampus.models.campus;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// 엔터티 클래스 관련 주요 애너테이션 소개
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "Id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "FirstName", nullable = false)
    private String firstName;
    
    @Column(name = "LastName", length = 20)
    private String lastName; 

    @Column(name = "Email", nullable = true)
    private String email; 

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Course> courses;

    private LocalDateTime created; 
    
    public Student() {
        
    }
    
    public Student(String firstName, String lastName, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public Student(String firstName, String lastName, String email, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setEmail(email);
        this.courses = courses;
    }

    public Student(Integer id, String firstName, String lastName, String email, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
