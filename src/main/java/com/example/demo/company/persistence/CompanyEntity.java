package com.example.demo.company.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "company")
public class CompanyEntity {

    public CompanyEntity() {
    }

    public CompanyEntity(UUID id) {
        this.id = id;
    }

    @Id
    private UUID id;

    private String name;

    private String vatId;

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

    public void setVatId(String vat_id) {
        this.vatId = vat_id;
    }
}
