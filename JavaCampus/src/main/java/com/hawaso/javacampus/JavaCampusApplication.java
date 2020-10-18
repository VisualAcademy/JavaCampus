package com.hawaso.javacampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JavaCampusApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaCampusApplication.class, args);
	}

	@RestController	
	@RequestMapping("/api")
	public class CreatorController {
		@GetMapping("/creator")
		public String getCreator() {
			return "RedPlus";
		}
	}
}
