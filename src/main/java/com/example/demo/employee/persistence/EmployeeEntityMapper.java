package com.example.demo.employee.persistence;

import com.example.demo.company.persistence.CompanyEntityMapper;
import com.example.demo.employee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper {

    private CompanyEntityMapper companyEntityMapper;

    public EmployeeEntityMapper(CompanyEntityMapper companyEntityMapper) {
        this.companyEntityMapper = companyEntityMapper;
    }

    public EmployeeEntity modelToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setName(employee.getName());
        employeeEntity.setCompanyEntity(this.companyEntityMapper.modelToEntity(employee.getCompany()));
        return employeeEntity;
    }

    public Employee entityToModel(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setName(employeeEntity.getName());
        employee.setCompany(this.companyEntityMapper.entityToModel(employeeEntity.getCompanyEntity()));
        return employee;
    }
}
