package com.example.demo.company.persistence;

import com.example.demo.company.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEntityMapper {

    public CompanyEntity modelToEntity(Company company) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(company.getId());
        companyEntity.setName(company.getName());
        companyEntity.setVat_id(company.getVat_id());
        return companyEntity;
    }

    public Company entityToModel(CompanyEntity companyEntity) {
        Company company = new Company();
        company.setId(companyEntity.getId());
        company.setName(companyEntity.getName());
        company.setVat_id(companyEntity.getVat_id());
        return company;
    }

}
