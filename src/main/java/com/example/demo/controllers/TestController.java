package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello, %s!", name);
	}

    @GetMapping("/")
    public String landing() {
        return "Redefining Masculinity through Mental Health, Mentorship, and More";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Goodbye from the demo application!";
    }

    @GetMapping("/signin")
    public String signin() {
        return "Sign in!";
    }

    @GetMapping("/signup")
    public String signup() {
        return "Sign up!";
    }
}
