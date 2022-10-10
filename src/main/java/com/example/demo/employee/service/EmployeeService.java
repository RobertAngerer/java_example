package com.example.demo.employee.service;

import com.example.demo.employee.model.Employee;
import com.example.demo.employee.persistence.EmployeeEntityMapper;
import com.example.demo.employee.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private EmployeeEntityMapper employeeEntityMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    public Employee save(Employee employee) {
        return this.employeeEntityMapper.entityToModel(this.employeeEntityMapper.modelToEntity(employee));
    }

    public Employee associateWithRoles(Employee employee) {
        return null;
    }

    public boolean existsById(UUID id) {
        return this.employeeRepository.existsById(id);
    }

}
