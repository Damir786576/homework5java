package com.example.stream.service.api;

import com.example.stream.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryDepartment(int department);

    Employee findMinSalaryDepartment(int department);

    List<Employee> allEmployeeDepartment(int department);

    Employee findMaxSalaryEmployeeByDepartment(int department);

    Employee findMinSalaryEmployeeByDepartment(int department);

    List<Employee> allEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> allEmployeesDepartments();
}
