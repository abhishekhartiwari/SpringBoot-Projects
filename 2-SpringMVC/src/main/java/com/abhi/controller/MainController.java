package com.abhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		System.out.println("This is home page");
		return "home";
	}
	
	@GetMapping("/contact")
	public String contact() {
		System.out.println("This is contact page");
		return "contact";
	}
}
