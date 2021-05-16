package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Selin") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/check")
	public ResponseEntity<String> checker(@RequestBody String wordchecker) {
		// Hier checkt er gegen mit equals() --> nicht == verwenden!
		if (wordchecker.equals("check mich")) {
			// HttpStatus.OK ist 200 also alles i.o.
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		// HttpStatus.BadRequest ist 400 also fehlerhafte Eingabe
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("/student")
	public String viewStudents () {
		Student student1 = new Student("Selin");
		student1.setAge(22);

		String studentObjectMappedToJSONString = null;

		ObjectMapper om = new ObjectMapper();
		try {
			studentObjectMappedToJSONString = om.writeValueAsString(student1);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return studentObjectMappedToJSONString;
	}


}