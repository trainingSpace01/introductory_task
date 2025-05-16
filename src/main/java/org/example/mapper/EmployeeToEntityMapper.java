package org.example.mapper;


import org.example.dao.EmployeeEntity;
import org.example.userService.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeToEntityMapper {
    EmployeeEntity employeeToEntity(Employee employee);
    Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);
}
