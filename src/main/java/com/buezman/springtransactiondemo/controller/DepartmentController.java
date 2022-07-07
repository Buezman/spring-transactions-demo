package com.buezman.springtransactiondemo.controller;

import com.buezman.springtransactiondemo.entity.Department;
import com.buezman.springtransactiondemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("save")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
