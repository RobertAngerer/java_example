package com.example.demo.roles.dto;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.roles.dto.RoleDto;

import java.util.UUID;

public record RoleDto(UUID id, String role, CompanyDto companyDto) {


}
