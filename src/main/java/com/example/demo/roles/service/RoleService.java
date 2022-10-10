package com.example.demo.roles.service;

import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.roles.model.Role;
import com.example.demo.roles.persistence.RoleEntityMapper;
import com.example.demo.roles.persistence.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    private RoleEntityMapper roleEntityMapper;

    public RoleService(RoleRepository roleRepository, RoleEntityMapper roleEntityMapper) {
        this.roleRepository = roleRepository;
        this.roleEntityMapper = roleEntityMapper;
    }

    public Role save(Role role) {
        return this.roleEntityMapper.entityToModel(this.roleRepository.save(this.roleEntityMapper.modelToEntity(role)));
    }

    public boolean areValidRoles(String[] roles, UUID company_id) {
        this.roleRepository.exists
        Arrays.stream(roles).map(role ->  )
    }

    private boolean isValidRole(String role, UUID company_id) {
        return this.
        return this.roleRepository.existsByCompanyEntityAndRole(new CompanyEntity(company_id), role)

    }




}
