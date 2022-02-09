package com.hawaso.javacampus.models.notices;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Notices")
public class Notice {
    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @NotBlank(message = "Name을 입력하세요.")
    @Column(name = "Name")
    @Size(min = 2, max = 25)
    private String name; 

    @NotBlank(message = "Title을 입력하세요.")
    @Column(name = "Title")
    @Size(min = 1, max = 150)
    private String title;

    @Column(name = "Content")
    private String content;     

    // 생성자
    public Notice() {
    }
    public Notice(String name, String title, String content) {
        this.setName(name);
        this.setTitle(title);
        this.setContent(content);
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
    public void setId(Integer id) {
        this.id = id; 
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
        return "Notice{id = " + this.id + ", name = '" 
            + this.name + "', title = '" + this.title + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Notice))
            return false;
            Notice model = (Notice) o;
        return 
            Objects.equals(this.id, model.id) 
            && 
            Objects.equals(this.name, model.name)
            && 
            Objects.equals(this.title, model.title) 
            && 
            Objects.equals(this.content, model.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.title, this.content);
    }
}
