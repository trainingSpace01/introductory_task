package org.example.service;

import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;


public interface EmployeeService {
    EmployeeRequest getEmployeeByID(Long id) throws Exception;
    EmployeeRequest getEmployeeByIDOut(Long id) throws Exception;
    List<EmployeeRequest> getAllEmployees();
    void addEmployee(EmployeeRequest employee);
}