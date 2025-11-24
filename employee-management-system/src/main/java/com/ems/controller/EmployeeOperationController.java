package com.ems.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.service.IDepartmentService;
import com.ems.service.IEmployeeService;
import com.ems.vo.EmployeeVO;

import jakarta.validation.Valid;

@Controller
public class EmployeeOperationController {

	@Autowired
	private IEmployeeService empService;
	@Autowired
	private IDepartmentService deptService;
	
	//Handler method for launching home page
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	//Handler method for launching employees page
	@GetMapping("/employees")
	public String employees(Model model) {
		List<Employee> employeeList= empService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		return "employees";
	}
	
	//Handler method for launching add_employee.jsp
	
	@GetMapping("/add")
	public String addEmployee(@ModelAttribute("employee") EmployeeVO vo,Model model) {
		List<Department> deptList = deptService.getAllDepartment();
		model.addAttribute("deptList", deptList);
		return "add_employee";
	}
	
	// Handler method for submitting add_employee.jsp
	@PostMapping("/add")
	public String addEmployee( @Valid @ModelAttribute("employee") EmployeeVO vo,BindingResult errors,  RedirectAttributes rab) {
		if(errors.hasErrors()) {
			return "add_employee";
		}
		String msg = empService.addEmployee(vo);
		rab.addFlashAttribute("msg",msg);
		return "redirect:employees";
	}
	
	//Handler method for launching update employee update_employee.jsp
	@GetMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") EmployeeVO vo,@RequestParam("empId") Long id,Model model) {
		Employee emp = empService.getEmployee(id);
		BeanUtils.copyProperties(emp, vo);
		vo.setDeptId(emp.getDepartment().getDeptId());
		List<Department> deptList = deptService.getAllDepartment();
		model.addAttribute("deptList", deptList);
		return "update_employee";
	}
	
	//Handler method for submitting update_employee.jsp page
	@PostMapping("/update")
	public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeVO vo,BindingResult errors,RedirectAttributes rda) {
		if(errors.hasErrors()) {
			return "update_employee";
		}
		String msg = empService.updateEmployee(vo);
		rda.addFlashAttribute("msg", msg);
		return "redirect:employees";
	}
	
	//Handler method for deletion
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("empId") Long id,RedirectAttributes rda) {
		rda.addFlashAttribute("msg", empService.deleteEmployee(id));
		return "redirect:employees";
	}
}
