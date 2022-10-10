package com.example.demo.company.service;

import com.example.demo.company.model.Company;
import com.example.demo.company.persistence.CompanyEntityMapper;
import com.example.demo.company.persistence.CompanyRepository;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    private CompanyEntityMapper companyEntityMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyEntityMapper companyEntityMapper) {
        this.companyRepository = companyRepository;
        this.companyEntityMapper = companyEntityMapper;
    }

    public Company findById(UUID id) {
        return this.companyEntityMapper.entityToModel(this.companyRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public boolean existsById(UUID id) {
        return this.companyRepository.existsById(id);
    }

    public Company save(Company company) {
        return companyEntityMapper.entityToModel(this.companyRepository.save(this.companyEntityMapper.modelToEntity(company)));
    }
}
