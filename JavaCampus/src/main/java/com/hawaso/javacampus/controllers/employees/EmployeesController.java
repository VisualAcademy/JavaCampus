package com.hawaso.javacampus.controllers.employees;

import java.util.List;
import java.util.Optional;

import com.hawaso.javacampus.models.employees.Employee;
import com.hawaso.javacampus.repositories.employees.EmployeeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/employees") // 컨트롤러 레벨에서 라우팅(api 경로) 지정하는게 좀 더 적은 코드 사용 가능
public class EmployeesController {
    // Repository 인터페이스 주입(생성자 매개 변수 주입 방식 사용할 때에는 @Autowired 생략)
    private final EmployeeRepository _repository;

    public EmployeesController(EmployeeRepository repository) {
        this._repository = repository;
    }

    // 출력: GetEmployees 
    @GetMapping("/api/employees")
    public List<Employee> all() {
        return _repository.findAll();
    }

    // 입력: PostEmployee 
    @PostMapping("/api/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        //return _repository.saveAndFlush(newEmployee);
        return _repository.save(newEmployee);
    }

    // 상세: GetEmployee
    @GetMapping("/api/employees/{id}")
    public Optional<Employee> one(@PathVariable Integer id) {
        return _repository.findById(id);
    }

    // 수정: PutEmployee
    @PutMapping("/api/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Integer id) {
        // 다음 2가지 방식 중 하나의 코드 사용하여 데이터 수정 
        if (System.currentTimeMillis() % 2 == 0) {
            // 1번 방식
            Employee old = _repository.getById(id);
            BeanUtils.copyProperties(newEmployee, old, "id");
            return _repository.saveAndFlush(old);
        } else {
            // 2번 방식
            return _repository.findById(id).map(employee -> {
                employee.setName(newEmployee.getName());
                employee.setRole(newEmployee.getRole());
                return _repository.save(employee);
            }).orElseGet(() -> {
                newEmployee.setId(id);
                return _repository.save(newEmployee);
            });
        }
    }

    // 삭제: DeleteEmployee
    @DeleteMapping("/api/employees/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        _repository.deleteById(id);
    }
}
