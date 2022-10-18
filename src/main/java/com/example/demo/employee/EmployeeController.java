package com.example.demo.employee;

import com.example.demo.company.model.Company;
import com.example.demo.company.service.CompanyService;
import com.example.demo.employee.dto.EmployeeDto;
import com.example.demo.employee.mapper.EmployeeDtoMapper;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.service.EmployeeService;
import com.example.demo.exception.NotFoundException;
import com.example.demo.role.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/companies/{company_id}/employees")
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

    @PostMapping
    public EmployeeDto createEmployee(@PathVariable("company_id") UUID company_id, @RequestBody EmployeeDto employeeDto) {
        Employee employee = this.employeeDtoMapper.dtoToModel(employeeDto);
        employee.setCompany(this.companyService.findById(company_id));
        return this.employeeDtoMapper.modelToDto(this.employeeService.save(employee));
    }

    @GetMapping("/employee_id")
    public EmployeeDto findById(@PathVariable("employee_id") UUID employee_id) {
        return this.employeeDtoMapper.modelToDto(this.employeeService.findById(employee_id));
    }

    @PutMapping("/{employee_id}")
    public EmployeeDto putById(@PathVariable("company_id") UUID company_id, @PathVariable("employee_id") UUID employee_id, @RequestBody EmployeeDto employeeDto) {
        if (!this.companyService.existsById(company_id)) {
            throw new NotFoundException();
        }
        if (!this.employeeService.existsById(employee_id)) {
            throw new NotFoundException();
        }
        Employee employee = this.employeeDtoMapper.dtoToModel(employeeDto, employee_id);
        employee.setCompany(this.companyService.findById(company_id));
        return this.employeeDtoMapper.modelToDto(this.employeeService.save(employee));
    }

    @GetMapping
    public List<EmployeeDto> getAllByCompanyId(@PathVariable("company_id") UUID company_id) {
        return this.employeeService.findAllByCompanyId(company_id).stream().map(employee -> this.employeeDtoMapper.modelToDto(employee)).collect(Collectors.toList());
    }

    @PutMapping("/{employee_id}/roles")
    public EmployeeDto associateRolesWithEmployee(@PathVariable("company_id") UUID company_id, @PathVariable("employee_id") UUID employee_id, @RequestBody() String[] roles) {
        Company company = this.companyService.findById(company_id);
        Employee employee = this.employeeService.findById(employee_id);
        employee.setCompany(company);
        return this.employeeDtoMapper.modelToDto(this.roleService.associateEmployeeWithRoles(employee, roles));
    }

}
