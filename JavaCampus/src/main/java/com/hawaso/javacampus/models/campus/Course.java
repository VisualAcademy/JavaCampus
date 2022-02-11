package com.hawaso.javacampus.models.campus;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
