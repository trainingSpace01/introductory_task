package org.example.mapper;

import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeToDTOMapper {
    Employee AddEmployeeRequestToEmployee(EmployeeRequest employeeRequest);

//    @Mapping(source = "firstname", target = "firstname")
    EmployeeRequest AddEmployeeToEmployeeRequest (Employee employee);
}
