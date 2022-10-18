package com.example.demo.employee.persistence;

import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.employee.model.Employee;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeDao {

    private EmployeeRepository employeeRepository;

    private EmployeeEntityMapper employeeEntityMapper;

    public EmployeeDao(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    public Employee save(Employee employee) {
        return this.employeeEntityMapper.entityToModel(this.employeeRepository.save(this.employeeEntityMapper.modelToEntity(employee)));
    }

    public Employee findById(UUID id) {
        return this.employeeEntityMapper.entityToModel(this.employeeRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public boolean existsById(UUID id) {
        return this.employeeRepository.existsById(id);
    }

    public boolean numberAlreadyExists(Integer number) {
        return this.employeeRepository.existsByNumber(number);
    }

    public List<Employee> findAllByCompanyId(UUID company_id) {
        return this.employeeRepository.findAllByCompany_id(company_id).stream().map(employeeEntity -> this.employeeEntityMapper.entityToModel(employeeEntity)).collect(Collectors.toList());
    }

}
