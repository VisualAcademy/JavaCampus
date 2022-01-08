// 모델 클래스 
package com.hawaso.javacampus.models.todos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Todo 모델 클래스: Todos 테이블과 일대일로 매핑
@Entity(name = "Todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Boolean isDone;    
    public Todo() { }
    public Todo(String title, Boolean isDone) {
        this.setTitle(title);
        this.setIsDone(isDone);
    }
    public Integer getId() {
        return id; 
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }    
    public Boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
