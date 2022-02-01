package com.hawaso.javacampus.models.campus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 일련번호 

    private String title; // 제목 

    private Integer credits; // 학점

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
