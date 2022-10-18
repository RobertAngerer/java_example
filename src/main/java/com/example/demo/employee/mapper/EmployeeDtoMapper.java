package com.example.demo.employee.mapper;

import com.example.demo.company.mapper.CompanyDtoMapper;
import com.example.demo.employee.dto.EmployeeDto;
import com.example.demo.employee.model.Employee;
import com.example.demo.role.mapper.RoleDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoMapper {

    private CompanyDtoMapper companyDtoMapper;

    private RoleDtoMapper roleDtoMapper;

    public EmployeeDtoMapper(CompanyDtoMapper companyDtoMapper, RoleDtoMapper roleDtoMapper) {
        this.companyDtoMapper = companyDtoMapper;
        this.roleDtoMapper = roleDtoMapper;
    }

    public Employee dtoToModel(EmployeeDto employeeDto, UUID id) {
        return new Employee(id, employeeDto.name(), employeeDto.number());
    }

    public Employee dtoToModel(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.name());
        return employee;
    }

    public EmployeeDto modelToDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName(), employee.getNumber(), this.companyDtoMapper.modelToDto(employee.getCompany()), employee.getRoles().stream().map(role -> roleDtoMapper.modelToSimpleDto(role)).collect(Collectors.toList()));
    }



}
