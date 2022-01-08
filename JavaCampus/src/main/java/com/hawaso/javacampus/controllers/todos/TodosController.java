package com.hawaso.javacampus.controllers.todos;

import java.util.List;
import java.util.Optional;

import com.hawaso.javacampus.models.todos.Todo;
import com.hawaso.javacampus.repositories.todos.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/api/v1/todos") // 버전 지정 가능
@RestController
@RequestMapping("/api/todos")
public class TodosController {
    @Autowired
    private TodoRepository _todoRepository;

    // 입력
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 Created.
    public Todo add(@RequestBody final Todo model) {
        return _todoRepository.saveAndFlush(model);
    }

    // 출력
    @GetMapping
    public List<Todo> getAll() {
        return _todoRepository.findAll(); 
    }

    // 상세보기
    @GetMapping
    @RequestMapping("{id}")
    public Optional<Todo> getById(@PathVariable Integer id) {
        //return _todoRepository.getOne(id); // Optional<Todo> => Todo
        return _todoRepository.findById(id);
    }

    // 수정
    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Todo update(@PathVariable Integer id, @RequestBody Todo model) {
        //var oldTodo = _todoRepository.getById(id);
        var oldModel = _todoRepository.getOne(id); 
        oldModel.setTitle(model.getTitle());
        oldModel.setIsDone(model.getIsDone());
        //BeanUtils.copyProperties(model, oldModel, "id"); // 더 편한 방법 제공
        return _todoRepository.saveAndFlush(oldModel); 
    }

    // 삭제
    @DeleteMapping
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        _todoRepository.deleteById(id);
    }
}
