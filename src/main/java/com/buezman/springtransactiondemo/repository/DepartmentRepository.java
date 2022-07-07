package com.buezman.springtransactiondemo.repository;

import com.buezman.springtransactiondemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByName(String departmentName);
}
