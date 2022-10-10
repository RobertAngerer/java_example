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
        company.setVat_id(createCompanyDto.vat_id());
        return company;
    }

    public CompanyDto modelToDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getVat_id());
    }
}
