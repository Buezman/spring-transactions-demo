package com.buezman.springtransactiondemo.service;

import com.buezman.springtransactiondemo.dto.EmployeeDto;
import com.buezman.springtransactiondemo.entity.Department;
import com.buezman.springtransactiondemo.entity.Employee;
import com.buezman.springtransactiondemo.repository.DepartmentRepository;
import com.buezman.springtransactiondemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    @Transactional
    public String saveEmployee(EmployeeDto employeeDto) {
        String departmentName = employeeDto.getDepartmentName().toLowerCase();
        Department department = Department.builder()
                .name(departmentName)
                .build();
        departmentService.saveDepartment(department);

        Employee employee = new Employee();
        employee.setName(employeeDto.getEmployeeName());
        employee.setEmail(employeeDto.getEmployeeEmail());
        employee.setDepartmentId(department.getId());
        employeeRepository.save(employee);

        return "Employee is saved with Employee_ID :" + employee.getId();
    }

}
