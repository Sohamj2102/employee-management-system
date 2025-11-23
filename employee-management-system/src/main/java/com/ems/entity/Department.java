package com.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="departments_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

	@Id
	private Integer deptId;
	private String deptName;
}
