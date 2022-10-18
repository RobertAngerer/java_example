package com.example.demo.role.service;

import com.example.demo.employee.model.Employee;
import com.example.demo.employee.persistence.EmployeeDao;
import com.example.demo.employee.persistence.EmployeeEntity;
import com.example.demo.exception.ConflictException;
import com.example.demo.role.model.Role;
import com.example.demo.role.persistence.RoleDao;
import com.example.demo.role.persistence.RoleEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private RoleDao roleDao;

    private EmployeeDao employeeDao;

    public RoleService(RoleDao roleDao, EmployeeDao employeeDao) {
        this.roleDao = roleDao;
        this.employeeDao = employeeDao;
    }

    public Role save(Role role) {
        return this.roleDao.save(role);
    }

    public void validateRoles(String[] roles, String[] validRoles) {
        final String[] temp = Arrays.stream(validRoles).map(String::trim).toArray(String[]::new);
        Arrays.stream(roles).forEach(role -> {
            if (!Arrays.asList(temp).contains(role)) {
                throw new ConflictException("Invalid role: {" + role + "} given");
            }
        });
    }

    public Employee associateEmployeeWithRoles(Employee employee, String[] futureRoles) {
        List<Role> roles = this.roleDao.findAllByCompanyId(employee.getCompany().getId());
        this.validateRoles(futureRoles, roles.stream().map(Role::getRole).toArray(String[]::new));
        employee.setRoles(this.filterValidGivenRoles(futureRoles, roles));
        return this.employeeDao.save(employee);
    }

    private Collection<Role> filterValidGivenRoles(String[] validGivenRoles, Collection<Role> roles) {
        Collection<String> validGivenRolesCol = Arrays.asList(validGivenRoles);
        return roles.stream().filter(role -> validGivenRolesCol.contains(role.getRole().trim())).collect(Collectors.toList());
    }

    public List<Role> findAllByCompanyID(UUID company_id) {
        return this.roleDao.findAllByCompanyId(company_id);
    }

}
