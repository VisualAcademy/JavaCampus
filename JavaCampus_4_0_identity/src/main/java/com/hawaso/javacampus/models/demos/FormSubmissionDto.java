package com.hawaso.javacampus.models.demos;

public class FormSubmissionDto {
    private Integer id;
    private String name;
    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
