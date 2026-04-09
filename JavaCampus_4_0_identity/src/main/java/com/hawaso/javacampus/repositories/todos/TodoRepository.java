package com.hawaso.javacampus.repositories.todos;

import com.hawaso.javacampus.models.todos.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    
}
