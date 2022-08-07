package com.hawaso.javacampus;

import com.hawaso.javacampus.models.shirts.Shirt;
import com.hawaso.javacampus.repositories.shirts.ShirtRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//public class JavaCampusApplication extends SpringBootServletInitializer {
public class JavaCampusApplication {
	// 스프링 부트 프로젝트의 엔트리 포인트
	public static void main(String[] args) {
		//[!] 기본 방식
		//SpringApplication.run(JavaCampusApplication.class, args);
		//[!!] 추가 기능 구현을 위한 방법
		SpringApplication app = new SpringApplication(JavaCampusApplication.class);
		app.setApplicationStartup(new BufferingApplicationStartup(10000));
		app.run(args); 
	}

	//[!] 인라인으로 REST API 만들고 실행하기
	//[1] /api/creator 경로 요청하면 "RedPlus" 문자열 출력
	@RestController	
	@RequestMapping("/api") // [Route]
	public class CreatorController {
		@GetMapping("/creator")
		public String getCreator() {
			return "RedPlus";
		}
	}
	//[2] /api/name 경로 요청하면 "박용준" 문자열 출력
	@RestController
	public class NameController {
		@RequestMapping("/api/name") // [Route] => [HttpGet]
		public String getName() {
			return "박용준";
		}
	}

	// 스프링 부트 DevTools 테스트
	@RestController
	public class DevToolsTestController {
		@GetMapping("/devtoolstest") // [HttpGet], [HttpPost], [HttpPut], [HttpDelete]
		public String index() {
			return "DevTools Test - Update - Update - Update";
		}
	}

	// 스프링 부트 프로젝트 처음 가동할 때 Shirt 개체 미리 생성
	private static final Logger log = LoggerFactory.getLogger(JavaCampusApplication.class);

    @Bean
    CommandLineRunner makeDefaultShirts(ShirtRepository repository) {
        return (args) -> {
            // save a few shirts
            repository.save(new Shirt("JavaCampus"));
            repository.save(new Shirt("VisualAcademy"));
            repository.save(new Shirt("DevLec"));
            repository.save(new Shirt("Hawaso"));

            // fetch all shirts
            log.info("Shirts found with findAll():");
            log.info("-------------------------------");
            for (Shirt shirt : repository.findAll()) {
                log.info(shirt.toString());
            }
            log.info("");
        };
    } 
}
