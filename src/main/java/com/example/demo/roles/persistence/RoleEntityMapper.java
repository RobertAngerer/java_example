package com.example.demo.roles.persistence;


import com.example.demo.company.persistence.CompanyEntityMapper;
import com.example.demo.roles.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityMapper {

    private CompanyEntityMapper companyEntityMapper;

    public RoleEntityMapper(CompanyEntityMapper companyEntityMapper) {
        this.companyEntityMapper = companyEntityMapper;
    }

    public RoleEntity modelToEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(role.getId());
        roleEntity.setRole(role.getRole());
        roleEntity.setCompanyEntity(this.companyEntityMapper.modelToEntity(role.getCompany()));
        return roleEntity;
    }

    public Role entityToModel(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(), roleEntity.getRole(), this.companyEntityMapper.entityToModel(roleEntity.getCompanyEntity()));

    }

}
