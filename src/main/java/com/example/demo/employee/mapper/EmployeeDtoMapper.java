package com.example.demo.employee.mapper;

import com.example.demo.company.mapper.CompanyDtoMapper;
import com.example.demo.company.persistence.CompanyEntityMapper;
import com.example.demo.employee.dto.CreateEmployeeDto;
import com.example.demo.employee.dto.EmployeeDto;
import com.example.demo.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeDtoMapper {

    private CompanyDtoMapper companyDtoMapper;

    public EmployeeDtoMapper(CompanyDtoMapper companyDtoMapper) {
        this.companyDtoMapper = companyDtoMapper;
    }

    public Employee createDtoToModel(CreateEmployeeDto createEmployeeDto) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setName(createEmployeeDto.name());
        return employee;
    }

    public EmployeeDto modelToDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName(), this.companyDtoMapper.modelToDto(employee.getCompany()));

    }


}
