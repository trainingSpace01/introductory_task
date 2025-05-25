package org.example.mapper;

import org.example.model.Company;
import org.example.model.CompanyRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyToDTOMapper {
    Company AddCompanyRequestToCompany(CompanyRequest companyRequest);
    CompanyRequest AddCompanyToCompanyRequest(Company company);
}
