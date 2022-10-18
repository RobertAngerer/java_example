package com.example.demo.role.dto;

import com.example.demo.company.dto.CompanyDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record RoleDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) UUID id, String role, @JsonProperty(access = JsonProperty.Access.READ_ONLY) CompanyDto companyDto) {


}
