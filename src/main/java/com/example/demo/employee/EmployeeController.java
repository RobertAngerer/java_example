package com.example.demo.employee;

import com.example.demo.company.model.Company;
import com.example.demo.company.service.CompanyService;
import com.example.demo.employee.dto.CreateEmployeeDto;
import com.example.demo.employee.dto.EmployeeDto;
import com.example.demo.employee.mapper.EmployeeDtoMapper;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.service.EmployeeService;
import com.example.demo.exception.NotFoundException;
import com.example.demo.roles.dto.RoleDto;
import com.example.demo.roles.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/companies/")
public class EmployeeController {

    private EmployeeService employeeService;
    private CompanyService companyService;
    private EmployeeDtoMapper employeeDtoMapper;
    private RoleService roleService;

    public EmployeeController(EmployeeService employeeService, CompanyService companyService, EmployeeDtoMapper employeeDtoMapper, RoleService roleService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.employeeDtoMapper = employeeDtoMapper;
        this.roleService = roleService;
    }

    @PostMapping("{company_id}/employees")
    public EmployeeDto createEmployee(@PathVariable("company_id") UUID company_id, @RequestBody CreateEmployeeDto createEmployeeDto) {
        Employee employee = this.employeeDtoMapper.createDtoToModel(createEmployeeDto);
        employee.setCompany(this.companyService.findById(company_id));
        return this.employeeDtoMapper.modelToDto(this.employeeService.save(employee));
    }

    @PostMapping("{company_id}/employees/{employee_id}/roles")
    public EmployeeDto associateRoleWithEmployee(@PathVariable("company_id") UUID company_id, @PathVariable("employee_id") UUID employee_id, @RequestBody String[] roles) {
        if (this.companyService.existsById(company_id)) {
            throw new NotFoundException();
        }
        if (this.employeeService.existsById(employee_id)) {
            throw new NotFoundException();
        }

        this.roleService.areValidRoles(roles, company_id)



    }



}
