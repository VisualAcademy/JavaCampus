package com.hawaso.javacampus.models;

public class Phone {
    private Integer id;
    private String title;
    private String phoneNumber;

    public Phone() {
    }

    public Phone(Integer id, String title, String phoneNumber) {
        this.id = id;
        this.title = title;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }    
}
