package com.example.demo.role.model;

import com.example.demo.company.model.Company;

import java.util.UUID;

public class Role {

    private UUID id;

    private String role;

    private Company company;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
        this.id = UUID.randomUUID();
    }

    public Role(UUID id, String role, Company company) {
        this.id = id;
        this.role = role;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
