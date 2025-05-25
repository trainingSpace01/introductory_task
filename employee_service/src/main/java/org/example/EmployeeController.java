package org.example;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.mapper.EmployeeToDTOMapper;
import org.example.service.EmployeeService;
import org.example.userService.model.Employee;
import org.example.userService.model.EmployeeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/employees")
@FeignClient("employee_service")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeToDTOMapper employeeToDTOMapper;

    @GetMapping("/{id}")
    public EmployeeRequest getEmployeeByID(@PathVariable Long id) throws Exception {
        return employeeService.getEmployeeByID(id);
    }

    @GetMapping("/out/{id}")
    public EmployeeRequest getEmployeeByIDOut(@PathVariable Long id) throws Exception {
        return employeeService.getEmployeeByIDOut(id);
    }

    @GetMapping
    public List<EmployeeRequest> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.addEmployee(employeeRequest);
    }
}
