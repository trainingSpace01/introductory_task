package org.example.service;

import org.example.userService.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByID(Long id) throws Exception;
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
}