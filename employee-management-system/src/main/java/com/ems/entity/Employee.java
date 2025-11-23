package com.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	@Column(length=30)
	private String name;
	private Double salary;
	@Column(length=30)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="dept_id" )
	private Department department;
	@Builder.Default
	private Integer status=1;
	
}
