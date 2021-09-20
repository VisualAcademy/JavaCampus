package com.hawaso.javacampus.models.notices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Notices")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    private String name; 
    private String title;
    private String content;     

    public Notice() {
    }
    public Notice(Integer id, String name, String title, String content) {
        this.id = id;
        this.setName(name);
        this.setTitle(title);
        this.setContent(content);
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
