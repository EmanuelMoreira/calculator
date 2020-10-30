package com.wit.calculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(scanBasePackages = "com.wit.calculator")
@RestController
public class RestApplication {
	private static Logger log = LoggerFactory.getLogger(RestApplication.class);

	private final ResponseEntityCreator responseEntityCreator;

	public RestApplication(ResponseEntityCreator responseEntityCreator) {
		this.responseEntityCreator = responseEntityCreator;
	}

	@RequestMapping(value="/sum", method=RequestMethod.GET)
	public ResponseEntity sum(@RequestParam(name = "a") String a, @RequestParam(name = "b") String b) {
		return responseEntityCreator.getResponseEntity(a, b, "sum");
	}

	@RequestMapping(value="/sub", method=RequestMethod.GET)
	public ResponseEntity sub(@RequestParam(name = "a") String a, @RequestParam(name = "b") String b) {
		return responseEntityCreator.getResponseEntity(a, b, "sub");
	}

	@RequestMapping(value="/mul", method=RequestMethod.GET)
	public ResponseEntity mul(@RequestParam(name = "a") String a, @RequestParam(name = "b") String b) {
		return responseEntityCreator.getResponseEntity(a, b, "mul");
	}

	@RequestMapping(value="/div", method=RequestMethod.GET)
	public ResponseEntity div(@RequestParam(name = "a") String a, @RequestParam(name = "b") String b) {
		return responseEntityCreator.getResponseEntity(a, b, "div");
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
