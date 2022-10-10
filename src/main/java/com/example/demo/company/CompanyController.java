package com.example.demo.company;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.mapper.CompanyDtoMapper;
import com.example.demo.company.model.Company;
import com.example.demo.company.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.company.dto.CreateCompanyDto;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    private CompanyService companyService;

    private CompanyDtoMapper companyDtoMapper;

    public CompanyController(CompanyService companyService, CompanyDtoMapper companyDtoMapper) {
        this.companyService = companyService;
        this.companyDtoMapper = companyDtoMapper;
    }


    @PostMapping
    public CompanyDto create(@RequestBody CreateCompanyDto createCompanyDto) {
        return this.companyDtoMapper.modelToDto(this.companyService.save(this.companyDtoMapper.createDtoToModel(createCompanyDto)));

    }

}
