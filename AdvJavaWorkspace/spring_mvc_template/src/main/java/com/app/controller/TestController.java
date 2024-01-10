package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("In ctor " + getClass());
	}
	
	@GetMapping("/test1")
	public ModelAndView getPage()
	{
		System.out.println("In Test Modular view");
		ModelAndView mv = new ModelAndView("/test/test1", "key" , LocalDateTime.now());
		return mv;
	}
}
