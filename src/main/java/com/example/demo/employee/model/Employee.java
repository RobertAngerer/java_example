package com.example.demo.employee.model;

import com.example.demo.company.model.Company;
import com.example.demo.roles.model.Role;

import java.util.Collection;
import java.util.UUID;

public class Employee {

    private UUID id;

    private String name;

    private Company company;

    private Collection[] roles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection[] getRoles() {
        return roles;
    }

    public void setRoles(Collection[] roles) {
        this.roles = roles;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
