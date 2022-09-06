package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {
	
		
		public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		}
		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();



		@GetMapping("/greeting")
		public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}
		@GetMapping("/")
		public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("<h1>Hello %s!</h1>", name);
		}
	
}






