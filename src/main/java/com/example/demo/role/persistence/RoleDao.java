package com.example.demo.role.persistence;

import com.example.demo.company.model.Company;
import com.example.demo.role.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleDao {

    private RoleRepository roleRepository;

    private RoleEntityMapper roleEntityMapper;

    public RoleDao(RoleRepository roleRepository, RoleEntityMapper roleEntityMapper) {
        this.roleRepository = roleRepository;
        this.roleEntityMapper = roleEntityMapper;
    }

    public Role save(Role role) {
        return this.roleEntityMapper.entityToModel(this.roleRepository.save(this.roleEntityMapper.modelToEntity(role)));
    }

    public List<Role> findAllByCompany(Company company) {
        return this.roleRepository.findAllByCompanyId(company.getId()).stream().map(roleEntity -> this.roleEntityMapper.entityToModel(roleEntity)).collect(Collectors.toList());
    }

    public List<Role> findAllByCompanyId(UUID company_id) {
        return this.roleRepository.findAllByCompanyId(company_id).stream().map(roleEntity -> this.roleEntityMapper.entityToModel(roleEntity)).collect(Collectors.toList());
    }
}
