package com.ems.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.repository.IDepartmentRepository;
import com.ems.repository.IEmployeeRepository;
import com.ems.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository empRepo;
	@Autowired
	IDepartmentRepository deptRepo;
	@Override
	public String addEmployee(EmployeeVO vo) {
		Employee emp=new Employee();
		Department department = deptRepo.findById(vo.getDeptId()).orElseThrow(()-> new IllegalArgumentException("Invalid deptId"));
		BeanUtils.copyProperties(vo, emp);
		emp.setDepartment(department);
		Long id = empRepo.save(emp).getEmpId();
		return id+" Employee Saved Succesfully!";
	}

	@Override
	public String updateEmployee(EmployeeVO vo) {
		Employee emp=empRepo.findById(vo.getEmpId()).orElseThrow(()->new IllegalArgumentException("Invalid empId"));
		Department department = deptRepo.findById(vo.getDeptId()).orElseThrow(()-> new IllegalArgumentException("Invalid deptId"));
		BeanUtils.copyProperties(vo, emp,"department","status");
		emp.setDepartment(department);
		Long id = empRepo.save(emp).getEmpId();
		return id+" Employee Updated Succesfully!";
	}

	@Override
	public String deleteEmployee(Long id) {
		empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid empId"));
		empRepo.deleteById(id);
		return id+ " Employee deleted succesfully!";
	}

	@Override
	public Employee getEmployee(Long id) {
		Employee employee = empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid empId"));
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

}
