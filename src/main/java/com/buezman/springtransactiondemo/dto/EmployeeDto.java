package com.buezman.springtransactiondemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String employeeName;
    private String employeeEmail;
    private String departmentName;

}
