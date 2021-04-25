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

	//[!] 인라인으로 REST API 만들고 실행하기
	//[1] /api/creator 경로 요청하면 "RedPlus" 문자열 출력
	@RestController	
	@RequestMapping("/api")
	public class CreatorController {
		@GetMapping("/creator")
		public String getCreator() {
			return "RedPlus";
		}
	}
	//[2] /api/name 경로 요청하면 "박용준" 문자열 출력
	@RestController
	public class NameController {
		@RequestMapping("/api/name")
		public String getName() {
			return "박용준";
		}
	}
}
