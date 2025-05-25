package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.CompanyRepository;
import org.example.dao.EmployeeListRepository;
import org.example.mapper.CompanyToDTOMapper;
import org.example.model.Company;
import org.example.model.CompanyRequest;
import org.example.model.EmployeeList;
import org.example.model.EmployeeRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    private final EmployeeListRepository employeeListRepository;
    private final CompanyToDTOMapper mapper;
    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}


    private CompanyRequest getCompanyInfo(Company company) throws Exception {
        CompanyRequest companyRequest =  mapper.AddCompanyToCompanyRequest(company);
        List<EmployeeRequest> employeeRequest = getEmployeesList(company.getId());
        companyRequest.setEmployeeRequestList(employeeRequest);
        return  companyRequest;
    }

    @Override
    public CompanyRequest getCompanyByID(Long id) throws Exception {
        Company company = companyRepository
                .findById(id).orElseThrow(() -> new Exception("Company not found: id = " + id));
        return getCompanyInfo(company);
    }

    @Override
    public CompanyRequest getCompanyByIDOut(Long id) throws Exception {
        Company company = companyRepository
                .findById(id).orElseThrow(() -> new Exception("Company not found: id = " + id));
        return mapper.AddCompanyToCompanyRequest(company);
    }

    @Override
    public List<CompanyRequest> getAllCompanies() throws Exception {
        Iterable<Company> companies = companyRepository.findAll();
        ArrayList<CompanyRequest> companyRequests = new ArrayList<>();

        for (Company company: companies){
            companyRequests.add(getCompanyInfo(company));
        }
        return companyRequests;
    }

    @Override
    public void addCompany(CompanyRequest companyRequest) {
        Company company = mapper.AddCompanyRequestToCompany(companyRequest);
        companyRepository.save(company);
    }

    @Override
    public void addEmployeeToCompany(Long employeeID, Long companyID) throws Exception {
        Company company = companyRepository
                .findById(companyID).orElseThrow(() -> new Exception("Company not found: id = " + companyID));
        EmployeeList employeeList = new EmployeeList();
        employeeList.setCompany_id(company);
        employeeList.setEmployee_id(employeeID);
        company.getEmployeesIDList().add(employeeList);
        companyRepository.save(company);
        employeeListRepository.save(employeeList);
    }

    @Override
    public List<EmployeeRequest> getEmployeesList(Long companyID) throws Exception {
        Company company = companyRepository
                .findById(companyID).orElseThrow(() -> new Exception("Company not found: id = " + companyID));
        CompanyRequest companyRequest = mapper.AddCompanyToCompanyRequest(company);
        List<Long> employeesIDs = company
                .getEmployeesIDList()
                .stream()
                .flatMap(x -> Stream.of(x.getEmployee_id()))
                .toList();
        ArrayList<EmployeeRequest> employees = new ArrayList<>();
        for (Long iter: employeesIDs) {
            EmployeeRequest employeeRequest = restTemplate()
                    .getForObject("http://localhost:9090/employees/out/{id}",
                            EmployeeRequest.class,
                            iter);
            employees.add(employeeRequest);
        }
        companyRequest.setEmployeeRequestList(employees);
        return companyRequest.getEmployeeRequestList();
    }
}
