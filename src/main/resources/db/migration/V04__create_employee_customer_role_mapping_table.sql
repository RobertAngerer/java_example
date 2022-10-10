create table employee_company_role_mapping (
    company_role_id uuid not null,
    employee_id uuid not null,
    primary key (company_role_id, employee_id)
);

alter table employee_company_role_mapping add constraint FK_company_role foreign key
    (company_role_id) references company_role (id);

alter table employee_company_role_mapping add constraint FK_employee foreign key
    (employee_id) references  employee(id);