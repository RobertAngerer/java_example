package com.example.demo.roles.service;

import com.example.demo.employee.model.Employee;
import com.example.demo.employee.persistence.EmployeeEntity;
import com.example.demo.employee.persistence.EmployeeEntityMapper;
import com.example.demo.employee.persistence.EmployeeRepository;
import com.example.demo.employee.service.EmployeeService;
import com.example.demo.exception.ConflictException;
import com.example.demo.roles.model.Role;
import com.example.demo.roles.persistence.RoleEntity;
import com.example.demo.roles.persistence.RoleEntityMapper;
import com.example.demo.roles.persistence.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    private EmployeeEntityMapper employeeEntityMapper;

    private RoleEntityMapper roleEntityMapper;

    private EmployeeRepository employeeRepository;


    public RoleService(RoleRepository roleRepository, EmployeeEntityMapper employeeEntityMapper, RoleEntityMapper roleEntityMapper, EmployeeRepository employeeRepository) {
        this.roleRepository = roleRepository;
        this.employeeEntityMapper = employeeEntityMapper;
        this.roleEntityMapper = roleEntityMapper;
        this.employeeRepository = employeeRepository;
    }

    public Role save(Role role) {
        return this.roleEntityMapper.entityToModel(this.roleRepository.save(this.roleEntityMapper.modelToEntity(role)));
    }

    public void validateRoles(String[] roles, String[] validRoles) {
        Arrays.stream(roles).forEach(role ->  {
            if (!Arrays.asList(validRoles).contains(role)) {
                throw new ConflictException("Invalid role: {" + role + "} given");
            }
        });
    }

    public Employee associateEmployeeWithRoles(Employee employee, String[] roles) {
        Collection<RoleEntity> roleEntities = this.roleRepository.findAllByCompanyId(employee.getCompany().getId());
        this.validateRoles(roles, roleEntities.stream().map(RoleEntity::getRole).toArray(String[]::new));
        EmployeeEntity employeeEntity = this.employeeEntityMapper.modelToEntity(employee);
        employeeEntity.setRoles(this.roleRepository.findAllByCompanyEntityAndRoleIn(employeeEntity.getCompanyEntity(), roles));
        return this.employeeEntityMapper.entityToModel(this.employeeRepository.save(employeeEntity));
    }

}
