package com.example.demo.role;

import com.example.demo.company.service.CompanyService;
import com.example.demo.role.dto.RoleDto;
import com.example.demo.role.dto.SimpleRoleDto;
import com.example.demo.role.mapper.RoleDtoMapper;
import com.example.demo.role.model.Role;
import com.example.demo.role.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/companies/{company_id}/roles")
public class RoleController {

    private RoleService rolesService;

    private RoleDtoMapper roleDtoMapper;

    private CompanyService companyService;


    public RoleController(RoleService rolesService, RoleDtoMapper roleDtoMapper, CompanyService companyService) {
        this.rolesService = rolesService;
        this.roleDtoMapper = roleDtoMapper;
        this.companyService = companyService;
    }

    @PostMapping
    public RoleDto save(@RequestBody RoleDto roleDto, @PathVariable("company_id") UUID company_id) {
        Role role = this.roleDtoMapper.dtoToModel(roleDto);
        role.setCompany(this.companyService.findById(company_id));
        return this.roleDtoMapper.modelToDto(this.rolesService.save(role));
    }

    @GetMapping
    public List<RoleDto> getAllByCompany(@PathVariable("company_id") UUID company_id) {
        return this.rolesService.findAllByCompanyID(company_id).stream().map(role -> this.roleDtoMapper.modelToDto(role)).collect(Collectors.toList());
    }
}
