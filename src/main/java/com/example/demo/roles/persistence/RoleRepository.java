package com.example.demo.roles.persistence;

import com.example.demo.company.model.Company;
import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.roles.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {


    public boolean existsByCompanyEntityAndRole(CompanyEntity companyEntity, Role role);

    public String[] findAllByCompanyEntity(CompanyEntity companyEntity);

    @Query("SELECT r.role from RoleEntity r where r.companyEntity.id = :company_id")
    public String[] findAllByCompanyId(UUID company_id);

}
