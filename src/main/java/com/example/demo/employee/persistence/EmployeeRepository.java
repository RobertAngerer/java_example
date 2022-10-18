package com.example.demo.employee.persistence;

import com.example.demo.company.model.Company;
import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {

    @Query("SELECT em from EmployeeEntity em where em.companyEntity.id = :company_id")
    public List<EmployeeEntity> findAllByCompany_id(UUID company_id);

    public List<EmployeeEntity> findAllByCompanyEntity(CompanyEntity companyEntity);

    public boolean existsByNumber(Integer number);
}
