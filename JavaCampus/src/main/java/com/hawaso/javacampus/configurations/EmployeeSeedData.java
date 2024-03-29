package com.hawaso.javacampus.configurations;

import com.hawaso.javacampus.models.employees.Employee;
import com.hawaso.javacampus.repositories.employees.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeSeedData {
  private static final Logger log = LoggerFactory.getLogger(EmployeeSeedData.class);

  @Bean
  public CommandLineRunner initEmployees(EmployeeRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Employee("길동", "홍", "Users")));
      log.info("Preloading " + repository.save(new Employee("두산", "백", "Managers")));
      log.info("Preloading " + repository.save(new Employee("꺽정", "임", "Administrators")));
    };
  }
}
