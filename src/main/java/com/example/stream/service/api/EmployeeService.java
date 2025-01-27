package com.example.stream.service.api;

import com.example.stream.model.Employee;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> getEmployeeMap();
}
