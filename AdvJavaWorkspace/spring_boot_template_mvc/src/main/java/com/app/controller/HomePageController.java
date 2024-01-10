package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("Home Page Controller");
	}
	@RequestMapping("/")
	public String getIndex()
	{
		System.out.println("Loading index");
		return ("/index");
	}
}
