package com.ems.service;

import java.util.List;

import com.ems.entity.Department;

public interface IDepartmentService {

	public List<Department> getAllDepartment();
	public Department getDepartmentById(Long id);
}
