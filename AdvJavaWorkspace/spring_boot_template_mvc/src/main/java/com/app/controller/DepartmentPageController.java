package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentPageController {
	@Autowired
	private DepartmentService departmentService;
	
	public DepartmentPageController() {
		System.out.println("In ctor"  +getClass());
	}

	@GetMapping("/list")
	public String getListPage(Model map)
	{
		System.out.println("In return ");
		map.addAttribute( "dept_list" , departmentService.getAllDepartments());
		return "/department/list";
	}
}
