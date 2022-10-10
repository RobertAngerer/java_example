package com.example.demo.roles;

import com.example.demo.company.service.CompanyService;
import com.example.demo.roles.dto.CreateRoleDto;
import com.example.demo.roles.dto.RoleDto;
import com.example.demo.roles.mapper.RoleDtoMapper;
import com.example.demo.roles.model.Role;
import com.example.demo.roles.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/companies/{company_id}/roles")
public class RolesController {

    private RoleService rolesService;

    private RoleDtoMapper roleDtoMapper;

    private CompanyService companyService;


    public RolesController(RoleService rolesService, RoleDtoMapper roleDtoMapper, CompanyService companyService) {
        this.rolesService = rolesService;
        this.roleDtoMapper = roleDtoMapper;
        this.companyService = companyService;
    }

    @PostMapping
    public RoleDto save(@RequestBody CreateRoleDto createRoleDto, @PathVariable("company_id") UUID company_id) {
        Role role = this.roleDtoMapper.createDtoToModel(createRoleDto);
        role.setCompany(this.companyService.findById(company_id));
        return this.roleDtoMapper.modelToDto(this.rolesService.save(role));
    }




}
