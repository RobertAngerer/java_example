package com.example.demo.roles.persistence;

import com.example.demo.company.persistence.CompanyEntity;
import com.example.demo.employee.persistence.EmployeeEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "company_role")
public class RoleEntity {

    @Id
    private UUID id;

    private String role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private CompanyEntity companyEntity;

    @ManyToMany(mappedBy = "roles")
    private Collection<EmployeeEntity> employees;

    public RoleEntity() {
    }

    public RoleEntity(String role, CompanyEntity companyEntity, Collection<EmployeeEntity> employees) {
        this.role = role;
        this.companyEntity = companyEntity;
        this.employees = employees;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }
}
