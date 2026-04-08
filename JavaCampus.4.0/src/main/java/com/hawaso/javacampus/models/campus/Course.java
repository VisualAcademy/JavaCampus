package com.hawaso.javacampus.models.campus;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id; // 일련번호

    @Column(name = "Title")
    private String title; // 제목

    @Column(name = "Credits")
    private Integer credits; // 학점

    @ManyToMany
    @JoinTable(name = "Enrollments", // CoursesStudents
            joinColumns = @JoinColumn(name = "CourseId"), inverseJoinColumns = @JoinColumn(name = "StudentId"))
    private List<Student> students;

    public Course() {

    }

    public Course(Integer id, String title, Integer credits, List<Student> students) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
