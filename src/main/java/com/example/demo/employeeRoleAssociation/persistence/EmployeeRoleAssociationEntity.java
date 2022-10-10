package com.example.demo.employeeRoleAssociation.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name= "employee_company_role_mapping")
public class EmployeeRoleAssociationEntity {

    @Id
    private UUID id;






}
