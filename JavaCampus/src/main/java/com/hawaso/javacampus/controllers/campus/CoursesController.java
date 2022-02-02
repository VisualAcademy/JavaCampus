package com.hawaso.javacampus.controllers.campus;

import java.util.List;

import com.hawaso.javacampus.models.campus.Course;
import com.hawaso.javacampus.repositories.campus.CourseRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private final CourseRepository _repository;

    public CoursesController(CourseRepository repository) {
        this._repository = repository;
    }

    // 출력
    @GetMapping
    public List<Course> index() {
        return _repository.findAll();
    }

    // 상세
    @GetMapping
    @RequestMapping("{id}")
    public Course details(@PathVariable Integer id) {
        return _repository.getById(id);
    }

    // 입력
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 Created.
    public Course create(@RequestBody final Course course) {
        return _repository.saveAndFlush(course);
    }
    
    // 수정: 초기 스프링은 @GetMapping과 @PostMapping만 제공하여 다음 모양 사용 가능
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Course edit(@PathVariable Integer id, @RequestBody Course course) {
        Course old = _repository.getById(id);
        BeanUtils.copyProperties(course, old, "id");
        return _repository.saveAndFlush(old);
    }    

    // 삭제
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        _repository.deleteById(id);
    }
}
