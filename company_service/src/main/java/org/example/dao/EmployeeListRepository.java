package org.example.dao;

import org.example.model.EmployeeList;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeListRepository extends CrudRepository<EmployeeList, Long> {
}
