package com.example.demo.company.persistence;
import com.example.demo.company.model.Company;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompanyDao {

    private CompanyRepository companyRepository;

    private CompanyEntityMapper companyEntityMapper;

    public CompanyDao(CompanyRepository companyRepository, CompanyEntityMapper companyEntityMapper) {
        this.companyRepository = companyRepository;
        this.companyEntityMapper = companyEntityMapper;
    }

    public Company save(Company company) {
        return this.companyEntityMapper.entityToModel(this.companyRepository.save(this.companyEntityMapper.modelToEntity(company)));
    }

    public Company findById(UUID id) {
        return this.companyEntityMapper.entityToModel(this.companyRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public boolean existsById(UUID id) {
        return this.companyRepository.existsById(id);
    }

    public void deleteById(UUID id) {
        this.companyRepository.deleteById(id);
    }

    public List<Company> findAll() {
        return this.companyRepository.findAll().stream().map(companyEntity -> companyEntityMapper.entityToModel(companyEntity)).collect(Collectors.toList());
    }

    public boolean vat_idAlreadyExists(String vatId) {
        return this.companyRepository.existsByVatId(vatId);

    }

}
