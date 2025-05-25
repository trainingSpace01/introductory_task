package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.EmployeeRepository;
import org.example.mapper.EmployeeToDTOMapper;
import org.example.userService.model.CompanyRequest;
import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeToDTOMapper mapper;
    public RestTemplate restTemplate() {return new RestTemplate();}



    @Override
    public EmployeeRequest getEmployeeByID(Long id) throws Exception {
        Employee employee = employeeRepository
                .findById(id).
                orElseThrow(() -> new Exception("Employee not found: id = " + id));
        return getEmployeeInfo(employee);
    }

    @Override
    public EmployeeRequest getEmployeeByIDOut(Long id) throws Exception {
        Employee employee = employeeRepository
                .findById(id).
                orElseThrow(() -> new Exception("Employee not found: id = " + id));
        return mapper.AddEmployeeToEmployeeRequest(employee);
    }

    private EmployeeRequest getEmployeeInfo(Employee employee){
        EmployeeRequest employeeRequest = mapper.AddEmployeeToEmployeeRequest(employee);
        CompanyRequest companyRequest = restTemplate()
                .getForObject("http://localhost:9091/companies/out/{id}",
                        CompanyRequest.class,
                        employee.getCompanyID());
        employeeRequest.setCompanyRequest(companyRequest);
        return employeeRequest;
    }

    @Override
    public List<EmployeeRequest> getAllEmployees() {

        Iterable<Employee> iterable = employeeRepository.findAll();

        ArrayList<EmployeeRequest> employees = new ArrayList<>();
        for (Employee employee : iterable) {
            employees.add(getEmployeeInfo(employee));
        }
        return employees;
    }

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = mapper.AddEmployeeRequestToEmployee(employeeRequest);
        employeeRepository.save(employee);
        restTemplate()
                .put("http://localhost:9091/companies/addEmployee/{e_id}/{c_id}",
                        CompanyRequest.class,
                        employee.getId(),
                        employee.getCompanyID());

    }
}
