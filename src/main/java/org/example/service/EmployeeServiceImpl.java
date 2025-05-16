package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.EmployeeRepository;
import org.example.mapper.EmployeeToDTOMapper;
import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeToDTOMapper mapper;

    @Override
    public EmployeeRequest getEmployeeByID(Long id) throws Exception {
        Employee employee = employeeRepository
                .findById(id).
                orElseThrow(() -> new Exception("Employee not found: id = " + id));

        return mapper.AddEmployeeToEmployeeRequest(employee);
    }

    @Override
    public List<EmployeeRequest> getAllEmployees() {

        Iterable<Employee> iterable = employeeRepository.findAll();

        ArrayList<EmployeeRequest> employees = new ArrayList<>();
        for (Employee employee : iterable) {
            employees.add(mapper.AddEmployeeToEmployeeRequest(employee));
        }
        return employees;
    }

    @Override
    public void addEmployee(EmployeeRequest employee) {
        Employee employeeEntity = mapper.AddEmployeeRequestToEmployee(employee);
        employeeRepository.save(employeeEntity);
    }
}
