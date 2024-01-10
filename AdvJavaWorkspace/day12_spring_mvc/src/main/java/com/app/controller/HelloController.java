package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass());
	}
	//add a req handling method to display a welcome mesg
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";
	}

}
