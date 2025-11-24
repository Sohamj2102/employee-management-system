package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.repository.IDepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	IDepartmentRepository deptRepo;
	@Override
	public List<Department> getAllDepartment() {
		return deptRepo.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department department = deptRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid deptId"));
		return department;
	}

}
