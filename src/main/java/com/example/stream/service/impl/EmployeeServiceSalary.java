package com.example.stream.service.impl;

import com.example.stream.exception.EmployeeNotFoundException;
import com.example.stream.model.Employee;
import com.example.stream.service.api.DepartmentService;
import com.example.stream.service.api.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceSalary implements DepartmentService {

    private final EmployeeService employeeService;

    public EmployeeServiceSalary(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No" + department));
    }

    @Override
    public Employee findMinSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("NO" + department));
    }

    @Override
    public List<Employee> allEmployeesByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }


    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeService.getEmployeeMap().values().stream()
                .collect(groupingBy(Employee::getDepartment));
    }

}