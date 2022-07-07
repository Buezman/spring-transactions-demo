package com.buezman.springtransactiondemo.repository;

import com.buezman.springtransactiondemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
