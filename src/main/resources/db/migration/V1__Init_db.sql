create table if not exists contract (
    cost integer not null,
    date date,
    sum_of_insurance integer not null,
    time_to_transport integer not null,
    weight integer not null,
    customer_id bigint,
    dispatcher_id bigint,
    id bigserial not null,
    user_id bigint,
    finish_station varchar(255),
    start_station varchar(255),
    type_of_cargo varchar(255),
    primary key (id));

create table if not exists customer (
    id bigserial not null,
    address varchar(255),
    company varchar(255),
    middlename varchar(255),
    name varchar(255),
    phone_number varchar(255),
    surname varchar(255),
    primary key (id));

create table if not exists dispatcher (
    experience integer not null,
    id bigserial not null,
    address varchar(255),
    company varchar(255),
    middlename varchar(255),
    name varchar(255),
    phone_number varchar(255),
    surname varchar(255),
    primary key (id));

create table if not exists user_role (
    user_id bigint not null,
    roles varchar(255)
        check (roles in ('ROLE_ADMIN','ROLE_USER')));

create table if not exists users (
    id bigserial not null,
    password varchar(255),
    username varchar(255),
    primary key (id));

alter table if exists contract add constraint FKq28qogy68douoc4gkgcy3ow9p foreign key (customer_id) references customer;
alter table if exists contract add constraint FK4t413gox1a1xl3ul42pfdxqpc foreign key (dispatcher_id) references dispatcher;
alter table if exists contract add constraint FKi6rphdb5rpnqnrp5twyk83jao foreign key (user_id) references users;
alter table if exists user_role add constraint FKj345gk1bovqvfame88rcx7yyx foreign key (user_id) references users;