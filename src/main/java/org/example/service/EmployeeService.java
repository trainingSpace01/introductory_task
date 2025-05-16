package org.example.service;

import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    EmployeeRequest getEmployeeByID(Long id) throws Exception;
    List<EmployeeRequest> getAllEmployees();
    void addEmployee(EmployeeRequest employee);
}