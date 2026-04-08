package com.hawaso.javacampus.controllers.demos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {	
    @Value("${foo}")
    private String foo; 

	@GetMapping("api/foo")
	public String getApplicationProperties() {
		return "application.properties 파일에서 동적으로 읽어온 값: " + foo;
	}
}
