package com.example.demo.employee.persistence;

import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.roles.persistence.RoleEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @ManyToMany
    @JoinTable(name = "employee_company_role_mapping",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_role_id"))
    private Collection<RoleEntity> roles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }
}
