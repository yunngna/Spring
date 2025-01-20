package com.example.demo.insa.service;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeesDTO {
	@NotNull(message ="사번을 입력 하세요")
	private Integer employeeId;
	private String firstName;
	@NotBlank(message="lastName을 입력 하시오")
	private String lastName;
	@NotBlank(message="이메일을 입력 하시오")
	private String email;
	private String phoneNumber;
	@NotNull(message="입사일을 입력 하시오")
	private Date hireDate;
	@NotBlank(message="역할을 입력 하시오")
	private String jobId;
	private Long salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;

}
