package com.example.demo.company.mapper;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.dto.CreateCompanyDto;
import com.example.demo.company.model.Company;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompanyDtoMapper {

    public Company createDtoToModel(CreateCompanyDto createCompanyDto) {
        Company company = new Company();
        company.setId(UUID.randomUUID());
        company.setName(createCompanyDto.name());
        company.setVatId(createCompanyDto.vat_id());
        return company;
    }

    public Company dtoToModel(CompanyDto companyDto) {
        return new Company(companyDto.name(), companyDto.vatId());
    }

    public Company dtoToModel(CompanyDto companyDto, UUID id) {
        return new Company(id, companyDto.name(), companyDto.vatId());
    }

    public CompanyDto modelToDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getVatId());
    }
}
