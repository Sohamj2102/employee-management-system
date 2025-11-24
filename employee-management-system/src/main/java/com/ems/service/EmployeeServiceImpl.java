package com.ems.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.repository.IEmployeeRepository;
import com.ems.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository empRepo;
	@Autowired
	IDepartmentService deptService;
	
	//Add Employee
	@Override
	public String addEmployee(EmployeeVO vo) {
		Employee emp=new Employee();
		Department department = deptService.getDepartmentById(vo.getDeptId());
		BeanUtils.copyProperties(vo, emp);
		emp.setDepartment(department);
		Long id = empRepo.save(emp).getEmpId();
		return " Employee with Id "+id+ " Saved Succesfully!";
	}

	//2.Update Employee
	@Override
	public String updateEmployee(EmployeeVO vo) {
		Employee emp=empRepo.findById(vo.getEmpId()).orElseThrow(()->new IllegalArgumentException("Invalid empId"));
		Department department = deptService.getDepartmentById(vo.getDeptId());
		BeanUtils.copyProperties(vo, emp,"department","status");
		emp.setDepartment(department);
		Long id = empRepo.save(emp).getEmpId();
		return " Employee with Id "+id+ " Updated Succesfully!";
	}
	
	
	//Delete Employee
	@Override
	public String deleteEmployee(Long id) {
		empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid empId"));
		empRepo.deleteById(id);
		return " Employee with Id "+id+ " deleted succesfully!";
	}

	//Get employee
	@Override
	public Employee getEmployee(Long id) {
		Employee employee = empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid empId"));
		return employee;
	}
	//Get all employee
	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

}
