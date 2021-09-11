package com.hawaso.javacampus.models.supports;

public class FaqItem {
    private Integer id;
    private String title;
    private String content;

    public FaqItem() {
    }
    public FaqItem(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public Integer getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
