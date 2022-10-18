package com.example.demo.company.service;

import com.example.demo.company.error.CompanyVatIdAlreadyExistsError;
import com.example.demo.company.model.Company;
import com.example.demo.company.persistence.CompanyDao;
import com.example.demo.company.persistence.CompanyEntityMapper;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private CompanyDao companyDAO;

    private CompanyEntityMapper companyEntityMapper;

    public CompanyService(CompanyDao companyDAO, CompanyEntityMapper companyEntityMapper) {
        this.companyDAO = companyDAO;
        this.companyEntityMapper = companyEntityMapper;
    }

    public Company findById(UUID id) {
        return this.companyDAO.findById(id);
    }

    public boolean existsById(UUID id) {
        return this.companyDAO.existsById(id);
    }

    public Company save(Company company) {
        if (this.companyDAO.vat_idAlreadyExists(company.getVatId())) {
            throw new CompanyVatIdAlreadyExistsError();
        }
        return this.companyDAO.save(company);
    }

    public void deleteById(UUID id) {
        if (!this.companyDAO.existsById(id)) {
            throw new NotFoundException();
        }
        this.companyDAO.deleteById(id);
    }

    public List<Company> findAll() {
        return this.companyDAO.findAll();
    }

}
