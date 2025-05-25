package org.example;


import lombok.RequiredArgsConstructor;
import org.example.mapper.CompanyToDTOMapper;
import org.example.model.Company;
import org.example.model.CompanyRequest;
import org.example.model.EmployeeRequest;
import org.example.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyToDTOMapper mapper;

    @GetMapping("/{id}")
    public CompanyRequest getCompanyByID(@PathVariable Long id)  throws Exception {
        return companyService.getCompanyByID(id);
    }

    @GetMapping("/out/{id}")
    public CompanyRequest getCompanyByIDOut(@PathVariable Long id)  throws Exception {
        return companyService.getCompanyByIDOut(id);
    }

    @GetMapping("/getAll")
    public List<CompanyRequest> getAllCompanies () throws Exception {return companyService.getAllCompanies();}

    @PostMapping("/addCompany")
    public void addCompany(@RequestBody CompanyRequest companyRequest) {
        companyService.addCompany(companyRequest);
    }

    @PutMapping("/addEmployee/{e_id}/{c_id}")
    public void addEmployeeToCompany(@PathVariable Long e_id, @PathVariable Long c_id) throws Exception {
        companyService.addEmployeeToCompany(e_id, c_id);
    }

    @GetMapping("/getEmployeeList/{c_id}")
    public List<EmployeeRequest> getEmployeesList(@PathVariable Long c_id) throws Exception {
        return companyService.getEmployeesList(c_id);
    }
}
