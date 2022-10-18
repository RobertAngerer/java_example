package com.example.demo.basetest;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.persistence.CompanyEntity;

import java.util.UUID;

public interface TestData {

    String BASE_URI = "/api/v1";

    String COMPANY_URI = BASE_URI + "/companies";

    String DEFAULT_COMPANY_NAME = "VALID_COMPANY_NAME";
    String DEFAULT_VAT_ID = "VALID_VAT_ID";




    default CompanyDto getValidCompanyDto() {
        return new CompanyDto(UUID.randomUUID(), DEFAULT_COMPANY_NAME, DEFAULT_VAT_ID);
    }

    default CompanyEntity getValidDefaultCompanyEntity() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(UUID.randomUUID());
        companyEntity.setName(DEFAULT_COMPANY_NAME);
        companyEntity.setVatId(DEFAULT_VAT_ID);
        return companyEntity;
    }
}
