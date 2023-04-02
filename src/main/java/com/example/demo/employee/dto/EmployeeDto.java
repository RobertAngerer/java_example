package com.example.demo.employee.dto;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.role.dto.SimpleRoleDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.UUID;

public record EmployeeDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UUID id,
        @NotBlank()
        @Min(2)
        String name,
        Integer number,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        CompanyDto companyDto,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Collection<SimpleRoleDto> roleDtos
) {
}
