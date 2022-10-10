package com.example.demo.roles.mapper;

import com.example.demo.company.mapper.CompanyDtoMapper;
import com.example.demo.roles.dto.CreateRoleDto;
import com.example.demo.roles.dto.RoleDto;
import com.example.demo.roles.model.Role;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoleDtoMapper {

    private CompanyDtoMapper companyDtoMapper;

    public RoleDtoMapper(CompanyDtoMapper companyDtoMapper) {
        this.companyDtoMapper = companyDtoMapper;
    }

    public Role createDtoToModel(CreateRoleDto createRoleDto) {
        Role role = new Role();
        role.setId(UUID.randomUUID());
        role.setRole(createRoleDto.role());
        return role;
    }

    public RoleDto modelToDto(Role role) {
        return new RoleDto(role.getId(), role.getRole(), this.companyDtoMapper.modelToDto(role.getCompany()));
    }

}
