package com.example.demo.company.model;

import java.util.UUID;

public class Company {

    private UUID id;

    private String name;

    private String vatId;

    public Company() {
    }

    public Company(UUID id, String name, String vatId) {
        this.id = id;
        this.name = name;
        this.vatId = vatId;
    }

    public Company(String name, String vatId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.vatId = vatId;
    }

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

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }
}
