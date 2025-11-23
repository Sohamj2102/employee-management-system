package com.ems.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeVO {

	
	private Long empId;
	
	@NotBlank(message = "Name  required")
	private String name;
	
	@NotNull(message = "Salary  required")
	@Positive(message = "Salary must be positive")
	private Double salary;
	
	@NotBlank(message ="Email required" )
	@Email(message = "Invalid Email")
	private String email;
	
	@NotNull(message = "Select a Department")
	private Long deptId;
	
	
}
