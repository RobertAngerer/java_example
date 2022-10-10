package com.example.demo.employee.model;

import com.example.demo.company.model.Company;

import java.util.UUID;

public class Employee {

    private UUID id;

    private String name;

    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}