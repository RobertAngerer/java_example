package com.example.demo.company.persistence;

import com.example.demo.company.persistence.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    boolean existsByVatId(String vatId);

}
