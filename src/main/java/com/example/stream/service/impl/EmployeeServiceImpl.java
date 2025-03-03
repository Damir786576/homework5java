package com.example.stream.service.impl;

import com.example.stream.exception.EmployeeAlreadyAddedException;
import com.example.stream.exception.EmployeeNotFoundException;
import com.example.stream.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServiceSalary {

    final Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>(Map.of(
                "Василий Пупкин", new Employee("Василий", "Пупкин", 1, 55000),
                "Анна Трубецкая", new Employee("Анна", "Трубецкая", 2, 54000),
                "Петр Корабелкин", new Employee("Петр", " Корабелкин", 3, 58000),
                "Ирина Иванова", new Employee("Ирина", "Иванова", 4, 67000),
                "Семен Крупский", new Employee("Семен", "Крупский", 5, 15000),
                "Алексей Шабанов", new Employee("Алексей", "Шабанов", 4, 127000),
                "Зинаила Семеновна", new Employee("Зинаида", "Семенова", 1, 45000),
                "Давид Мартиросян", new Employee("Давид", "Мартиросян", 4, 18700000),
                "Анастасия Турцкевич", new Employee("Анастасия", "Турцкевич", 3, 58000),
                "Лидия Разумихина", new Employee("Лидия", "Разумихина", 2, 76000)));


    }

    public Employee add(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeBook.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();

    }


    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }


}