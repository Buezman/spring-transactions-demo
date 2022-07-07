package com.buezman.springtransactiondemo.service;

import com.buezman.springtransactiondemo.entity.Department;
import com.buezman.springtransactiondemo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department request) {
        Department department = Department.builder()
                .name(request.getName().toLowerCase())
                .build();
        departmentRepository.save(department);
        department.setCode(generateDepartmentCode(department));
        departmentRepository.save(department);

        return department;
    }

    private String generateDepartmentCode(Department dep) {
        return dep.getName().substring(0,3).toUpperCase() + "0" + dep.getId();
    }
}
