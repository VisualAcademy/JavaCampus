package com.hawaso.javacampus.repositories;

import com.hawaso.javacampus.models.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    
}
