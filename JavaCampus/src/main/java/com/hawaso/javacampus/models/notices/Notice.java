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
    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    private String name; 
    private String title;
    private String content;     

    // 생성자
    public Notice() {
    }
    public Notice(Integer id, String name, String title, String content) {
        this.id = id;
        this.setName(name);
        this.setTitle(title);
        this.setContent(content);
    }

    // 게터와 세터 
    public Integer getId() {
        return id; 
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    // ToString 메서드 오버라이드 
    @Override
    public String toString() {
        return super.toString();
    }
}
