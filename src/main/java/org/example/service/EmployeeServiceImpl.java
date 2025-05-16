package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.EmployeeEntity;
import org.example.dao.EmployeeRepository;
import org.example.mapper.EmployeeToEntityMapper;
import org.example.userService.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeToEntityMapper mapper;

    @Override
    public Employee getEmployeeByID(Long id) throws Exception {
        EmployeeEntity employeeEntity = employeeRepository
                .findById(id).
                orElseThrow(() -> new Exception("Employee not found: id = " + id));

//        return mapper.employeeEntityToEmployee(employeeEntity);

        return new Employee(employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getPhoneNumber(),
                employeeEntity.getCompanyID());
    }

    @Override
    public List<Employee> getAllEmployees() {

        Iterable<EmployeeEntity> iterable = employeeRepository.findAll();

        ArrayList<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : iterable) {
            employees.add(mapper.employeeEntityToEmployee(employeeEntity));
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.employeeToEntity(employee);
        employeeRepository.save(employeeEntity);
    }
}
