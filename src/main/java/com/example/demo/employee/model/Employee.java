package com.example.demo.employee.model;

import com.example.demo.company.model.Company;
import com.example.demo.role.model.Role;

import java.util.Collection;
import java.util.UUID;

public class Employee {

    private UUID id;

    private String name;

    private Integer number;

    private Company company;

    private Collection<Role> roles;

    public Employee() {
        this.id = UUID.randomUUID();
    }

    public Employee(UUID id, String name, Integer number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Employee(UUID id, String name, Integer number, Company company, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.number = number;
        this.roles = roles;
    }

    public Employee(String name) {
        this.name = name;
    }

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
