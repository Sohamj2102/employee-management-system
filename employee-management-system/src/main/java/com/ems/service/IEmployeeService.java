package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;
import com.ems.vo.EmployeeVO;

public interface IEmployeeService {

	public String addEmployee(EmployeeVO vo);
	public String updateEmployee(EmployeeVO vo);
	public String deleteEmployee(Long id);
	public Employee getEmployee(Long id);
	public List<Employee> getAllEmployee();
	 
}
