package com.hawaso.javacampus.services.employees;

import java.util.List;

import com.hawaso.javacampus.models.employees.Employee;
import com.hawaso.javacampus.repositories.employees.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service // 현재 클래스를 서비스 클래스로 등록 => 컨트롤러 클래스에서 바로 주입 사용 가능 
public class EmployeeService implements IEmployeeService {
    // @Autowired 생략 가능: 생성자 주입 방식
    private final EmployeeRepository _repository;

    // 인터페이스 또는 클래스 리포지토리 주입
    public EmployeeService(EmployeeRepository repository) {
        this._repository = repository;
    }

    // 입력과 수정 
    @Override
    public void save(Employee model) {
        _repository.save(model);
    }

    // 출력
    @Override
    public List<Employee> getAll() {
        return _repository.findByOrderByIdDesc(); 
    }

    // 상세
    @Override
    public Employee getById(int id) {
        var result = _repository.findById(id);

        if (result.isPresent()) {
            return result.get(); 
        }
        else {
            throw new RuntimeException("No Data."); // EmployeeNotFoundException...
        }
    }

    // 삭제
    @Override
    public void delete(int id) {
        _repository.deleteById(id);
    }

    // 검색 
    @Override
    public List<Employee> searchAll(String firstName, String lastName) {
        return _repository.findByFirstNameContainsOrLastNameContainingIgnoreCase(firstName, lastName);
    }
}
