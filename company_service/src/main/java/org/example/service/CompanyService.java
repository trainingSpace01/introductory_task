package org.example.service;

import org.example.model.CompanyRequest;
import org.example.model.EmployeeRequest;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("company_service")
public interface CompanyService {
    CompanyRequest getCompanyByID(Long id) throws Exception;
    CompanyRequest getCompanyByIDOut(Long id) throws Exception;
    List<CompanyRequest> getAllCompanies() throws Exception;
    void addCompany(CompanyRequest companyRequest);
    void addEmployeeToCompany(Long employeeID, Long companyID) throws Exception;
    List<EmployeeRequest> getEmployeesList(Long companyID) throws Exception;
}
