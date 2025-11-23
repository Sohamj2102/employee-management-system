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
		Department department = deptRepo.findById(vo.getDeptId()).orElseThrow(()-> new NullPointerException("Department should not be Null"));
		BeanUtils.copyProperties(vo, emp);
		emp.setDepartment(department);
		Long id = empRepo.save(emp).getEmpId();
		return id+" Employee Saved Succesfully!";
	}

	@Override
	public String updateEmployee(EmployeeVO vo) {
		
		return null;
	}

	@Override
	public String deleteEmployee(Long id) {
		return null;
	}

	@Override
	public Employee getEmployee(Long id) {
		Employee employee = empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

}
