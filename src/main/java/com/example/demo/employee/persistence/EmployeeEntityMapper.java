package com.example.demo.employee.persistence;

import com.example.demo.company.persistence.CompanyEntityMapper;
import com.example.demo.employee.model.Employee;
import com.example.demo.role.persistence.RoleEntityMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeEntityMapper {

    private CompanyEntityMapper companyEntityMapper;

    private RoleEntityMapper roleEntityMapper;

    public EmployeeEntityMapper(CompanyEntityMapper companyEntityMapper, RoleEntityMapper roleEntityMapper) {
        this.companyEntityMapper = companyEntityMapper;
        this.roleEntityMapper = roleEntityMapper;
    }

    public EmployeeEntity modelToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setName(employee.getName());
        employeeEntity.setNumber(employee.getNumber());
        employeeEntity.setCompanyEntity(this.companyEntityMapper.modelToEntity(employee.getCompany()));
        employeeEntity.setRoles(employee.getRoles().stream().map(role -> this.roleEntityMapper.modelToEntity(role)).collect(Collectors.toList()));
        return employeeEntity;
    }

    public Employee entityToModel(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getNumber(), this.companyEntityMapper.entityToModel(employeeEntity.getCompanyEntity()), employeeEntity.getRoles().stream().map(roleEntity -> this.roleEntityMapper.entityToModel(roleEntity)).collect(Collectors.toList()));
    }
}
