package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String getEmployees(Model map, @RequestParam Long deptId)
	{
		map.addAttribute("emps", employeeService.getAllEmployeeById(deptId));
		return "/employee/list";
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam Long id ,@RequestParam Long deptId)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/emps/list?deptId=" + deptId;
	}
}
