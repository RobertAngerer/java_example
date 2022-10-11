package com.example.demo.roles.persistence;

import com.example.demo.company.model.Company;
import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.roles.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {


    public boolean existsByCompanyEntityAndRole(CompanyEntity companyEntity, Role role);

    public String[] findAllByCompanyEntity(CompanyEntity companyEntity);

    @Query("SELECT r from RoleEntity r where r.companyEntity.id = :company_id")
    public Collection<RoleEntity> findAllByCompanyId(UUID company_id);

    @Query("SELECT r from RoleEntity r where r.companyEntity.id = :company_id and r.role in :roles")
    public Collection<RoleEntity> findAllByCompanyIdAndRoles(UUID company_id, String[] roles);

    public Collection<RoleEntity> findAllByCompanyEntityAndRoleIn(CompanyEntity companyEntity, String[] roles);




}
