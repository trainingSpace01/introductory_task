package org.example.mapper;

import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeToDTOMapper {
    Employee AddEmployeeRequestToEmployee(EmployeeRequest employeeRequest);
    EmployeeRequest AddEmployeeToEmployeeRequest (Employee employee);
}
