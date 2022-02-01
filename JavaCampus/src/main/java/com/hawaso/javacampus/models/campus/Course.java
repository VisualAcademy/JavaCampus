package com.hawaso.javacampus.models.campus;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 일련번호 

    private String title; // 제목 

    private Integer credits; // 학점

    @ManyToMany
    @JoinTable(
        name = "Enrollments", // CoursesStudents 
        joinColumns = @JoinColumn(name = "CourseId"), 
        inverseJoinColumns = @JoinColumn(name = "StudentId"))
    private List<Student> students;

    public Course() {
        
    }

    public String getTitle() {
        return title;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setTitle(String title) {
        this.title = title;
    } 
}
