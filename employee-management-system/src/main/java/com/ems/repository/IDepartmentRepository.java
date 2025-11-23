package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

}
