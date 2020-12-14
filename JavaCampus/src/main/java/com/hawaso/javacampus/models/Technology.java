package com.hawaso.javacampus.models;

// 모델 클래스 
public class Technology {
    private long id;
    private String title;

    public Technology(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }
}
