package com.hawaso.javacampus.controllers.demos;

import java.util.concurrent.atomic.AtomicLong;

import com.hawaso.javacampus.models.demos.GreetingDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingDemoController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("api/greetingdemo")
	public GreetingDemo greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingDemo(counter.incrementAndGet(), String.format(template, name));
	}
}
