package com.example.demo.role.mapper;

import com.example.demo.company.mapper.CompanyDtoMapper;
import com.example.demo.role.dto.RoleDto;
import com.example.demo.role.dto.SimpleRoleDto;
import com.example.demo.role.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoMapper {

    private CompanyDtoMapper companyDtoMapper;

    public RoleDtoMapper(CompanyDtoMapper companyDtoMapper) {
        this.companyDtoMapper = companyDtoMapper;
    }

    public Role dtoToModel(RoleDto roleDto) {
        return new Role(roleDto.role());
    }

    public RoleDto modelToDto(Role role) {
        return new RoleDto(role.getId(), role.getRole(), this.companyDtoMapper.modelToDto(role.getCompany()));
    }

    public SimpleRoleDto modelToSimpleDto(Role role) {
        return new SimpleRoleDto(role.getId(), role.getRole());
    }

}
