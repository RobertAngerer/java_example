create table customer_roles
(

    id         UUID      not null,
    role       char(255) not null,
    company_id UUID      not null,
    primary key (id)
);

alter table customer_roles
    add constraint FK_company foreign key (company_id) references company (id);
