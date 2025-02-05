package com.abhi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String add() {
		
		int a = 21;
		int b = 21;
		return "addition of two numbers is : " + (a + b);
	}
	
}
