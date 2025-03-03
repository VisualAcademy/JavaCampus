package com.hawaso.javacampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Greeting 이름으로 컨트롤러 만들기 
@Controller
public class GreetingController {
	// greeting 이름으로 액션 메서드 만들기
	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name, // 쿼리스트링 받기
			Model model // 컨트롤러에서 뷰 페이지로 데이터 전송
	) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
