package com.example.stream.controller;

import com.example.stream.model.Employee;
import com.example.stream.service.impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary) {
        return service.add(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary) {
        return service.remove(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary) {
        return service.find(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/collection")
    public Collection<Employee> getCollection() {
        return service.getEmployees();
    }
}