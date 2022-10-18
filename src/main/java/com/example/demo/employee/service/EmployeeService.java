package com.example.demo.employee.service;

import com.example.demo.employee.error.EmployeeNumberAlreadyExists;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.persistence.EmployeeDao;
import com.example.demo.employee.persistence.EmployeeEntityMapper;
import com.example.demo.employee.persistence.EmployeeRepository;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    private EmployeeEntityMapper employeeEntityMapper;

    public EmployeeService(EmployeeDao employeeDao, EmployeeEntityMapper employeeEntityMapper) {
        this.employeeDao = employeeDao;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    public Employee save(Employee employee) {
        if (this.employeeDao.numberAlreadyExists(employee.getNumber())) {
            throw new EmployeeNumberAlreadyExists();
        }
        return this.employeeDao.save(employee);
    }

    public Employee findById(UUID id) {
        return this.employeeDao.findById(id);
    }

    public Employee updateById(Employee employee) {
        return this.employeeDao.save(employee);
    }

    public boolean existsById(UUID id) {
        return this.employeeDao.existsById(id);
    }

    public List<Employee> findAllByCompanyId(UUID company_id) {
        return this.employeeDao.findAllByCompanyId(company_id);
    }

}
