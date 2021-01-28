package com.hawaso.javacampus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecouplingController {
    //[1] 직접 인스턴스 생성
    //private DecouplingService service = new DecouplingService(); 

    //[2] 필드로 주입
    @Autowired 
    private DecouplingService _svc; 

    //[3] 생성자의 매개 변수로 주입
    private DecouplingService _service;
    @Autowired
    public DecouplingController(DecouplingService ds) {
        _service = ds; 
    }

    @GetMapping("/decoupling")
    public String welcome() {
        return "Decoupling: " + _svc.getMessage() + ", " + _service.getMessage();
    }
}

@Service
class DecouplingService {
    public String getMessage() {
        return "Decoupling from Service";
    }
}
