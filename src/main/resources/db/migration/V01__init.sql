create table company
(
    id     uuid         not null,
    name   varchar(255) not null,
    vat_id varchar(255) not null,

    primary key (id)
);

create table employee
(
    id   uuid         not null,
    name varchar(255) not null,
    company_id uuid,
    primary key (id)
);

alter table employee
    add constraint FK_company_ foreign key (company_id) references company(id);
