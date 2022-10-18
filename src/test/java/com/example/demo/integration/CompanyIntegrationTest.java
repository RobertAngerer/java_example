package com.example.demo.integration;

import com.example.demo.basetest.TestData;
import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.company.persistence.CompanyRepository;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
public class CompanyIntegrationTest implements TestData {

    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:8080/api/v1";
    }

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testPost_shouldAddCompany_200() throws Exception {
        CompanyDto companyDto = getValidCompanyDto();
        given().contentType(ContentType.JSON).body(companyDto).when().post("/companies").then().
                assertThat().statusCode(201).log().all().
                body("id", is(notNullValue())).
                body("name", is(companyDto.name())).
                body("vatId", is(companyDto.vatId()));
    }

    @Test
    public void testPost_withValidDto_shouldNotEqualGivenId_201() throws Exception {
        CompanyDto companyDto = getValidCompanyDto();
        given().contentType(ContentType.JSON).body(companyDto).when().post("/companies").then().
                assertThat().statusCode(201).log().all().
                body("id", not(companyDto.id())).
                body("name", is(companyDto.name())).
                body("vatId", is(companyDto.vatId()));
    }

    @Test
    public void testPost_withInvalidName_shouldFailValidation_400() throws Exception {
        CompanyDto companyDto = getValidCompanyDto();
        CompanyDto inValidCompanyDto = new CompanyDto(UUID.randomUUID(), "  ", DEFAULT_VAT_ID );
        given().contentType(ContentType.JSON).body(companyDto).when().post("/companies").then().
                assertThat().statusCode(400).log().all().
                body("id", is(notNullValue())).
                body("name", is(companyDto.name())).
                body("vatId", is(companyDto.vatId()));
    }

    @Test
    public void testPost_withInvalidVatID_shouldFailValidation_400() throws Exception {
        CompanyDto companyDto = getValidCompanyDto();
        CompanyDto inValidCompanyDto = new CompanyDto(UUID.randomUUID(), DEFAULT_COMPANY_NAME, "  ");
        given().contentType(ContentType.JSON).body(companyDto).when().post("/companies").then().
                assertThat().statusCode(400).log().all().
                body("id", is(notNullValue())).
                body("name", is(companyDto.name())).
                body("vatId", is(companyDto.vatId()));
    }
    @Test
    public void testGet_shouldGetCompany_200() throws Exception {
        CompanyEntity companyEntity = this.companyRepository.save(getValidDefaultCompanyEntity());
        when().get("/companies/" + companyEntity.getId()).then().assertThat().statusCode(200).
                body("id", is(notNullValue())).
                body("name", is(companyEntity.getName())).
                body("vatId", is(companyEntity.getVatId()));
    }

    @Test
    public void testGetAll_shouldGetAllCompanies_200() throws Exception {
        this.companyRepository.save(getValidDefaultCompanyEntity());
        this.companyRepository.save(getValidDefaultCompanyEntity());
        when().get("/companies").then().
                assertThat().statusCode(200).log().all().
                body("size()", is(2));
    }

    @Test
    public void testGetAll_whenNoCompanies_shouldGetEmptyResponse_200() throws Exception {
        when().get("/companies").then().
                assertThat().statusCode(200).
                body("size()", is(0));
    }

}
