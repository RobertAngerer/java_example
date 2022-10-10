package com.example.demo.employee.dto;

import com.example.demo.company.dto.CompanyDto;

import java.util.UUID;

public record EmployeeDto(UUID id, String name, CompanyDto companyDto) {
}
