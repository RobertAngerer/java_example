package com.example.demo.basetest;

import com.example.demo.company.dto.CompanyDto;

import java.util.UUID;

public interface TestData {

    String BASE_URI = "/api/v1";

    String COMPANY_URI = BASE_URI + "/companies";

    String DEFAULT_COMPANY_NAME = "VALID_COMPANY_NAME";
    String DEFAULT_VAT_ID = "VALID_VAT_ID";




    default CompanyDto getValidCompanyDto() {
        return new CompanyDto(UUID.randomUUID(), DEFAULT_COMPANY_NAME, DEFAULT_VAT_ID);
    }
}
