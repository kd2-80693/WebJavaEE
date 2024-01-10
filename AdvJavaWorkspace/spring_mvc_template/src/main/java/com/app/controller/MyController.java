package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	public MyController() {
		System.out.println("reached in my controller");
	}
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("in sayHello");
		return "/welcome";
	}
	
	
}
 