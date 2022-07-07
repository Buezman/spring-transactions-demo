package com.buezman.springtransactiondemo.controller;

import com.buezman.springtransactiondemo.dto.EmployeeDto;
import com.buezman.springtransactiondemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

}
