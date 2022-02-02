package com.hawaso.javacampus.controllers.campus;

import java.util.List;

import com.hawaso.javacampus.models.campus.Student;
import com.hawaso.javacampus.repositories.campus.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    @Autowired
    private StudentRepository _repository;

    @GetMapping
    public List<Student> index() {
        return _repository.findAll(); 
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student details(@PathVariable Integer id) {
        return _repository.getById(id); 
    }

    @PostMapping
    public Student create(@RequestBody final Student student) {
        return _repository.saveAndFlush(student);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        _repository.deleteById(id);        
    }
}
