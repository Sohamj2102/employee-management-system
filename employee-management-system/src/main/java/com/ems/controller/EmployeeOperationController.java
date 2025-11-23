package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ems.service.IEmployeeService;

@Controller
public class EmployeeOperationController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	
}
