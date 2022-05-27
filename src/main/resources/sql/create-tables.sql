create table car
(
    car_reg_number      varchar(45)  not null
        primary key,
    car_chassis_number  varchar(45)  not null,
    car_make            varchar(45)  not null,
    car_model           varchar(45)  not null,
    car_color           varchar(45)  null,
    car_equipment_level varchar(45)  not null,
    car_reg_fee         double       not null,
    car_emission        double       not null,
    car_status          varchar(45)  not null,
    car_url             varchar(400) null,
    constraint car_chassis_number_UNIQUE
        unique (car_chassis_number)
);


create table zipcode
(
    zipcode varchar(10) not null
        primary key,
    country varchar(45) not null,
    city    varchar(45) not null
);


create table customer
(
    customer_cpr_number varchar(20) not null
        primary key,
    customer_firstname  varchar(45) not null,
    customer_lastname   varchar(45) not null,
    customer_email      varchar(45) not null,
    customer_phone      varchar(45) not null,
    customer_zipcode    varchar(10) not null,
    customer_address    varchar(45) not null,
    constraint customer_zipcode
        foreign key (customer_zipcode) references zipcode (zipcode)
);

create index customer_zipcode_idx
    on customer (customer_zipcode);


create table user
(
    user_username varchar(45) not null
        primary key,
    user_password varchar(45) not null,
    user_role     varchar(45) not null
);

create table lease
(
    lease_car_reg_number      varchar(45) not null
        primary key,
    lease_price               int         not null,
    lease_customer_cpr_number varchar(20) not null,
    lease_account_number      varchar(45) not null,
    lease_reg_number          varchar(45) not null,
    lease_start_date          date        not null,
    lease_end_date            date        not null,
    constraint lease_car_reg_number
        foreign key (lease_car_reg_number) references car (car_reg_number)
            on delete cascade,
    constraint lease_customer_cpr_number
        foreign key (lease_customer_cpr_number) references customer (customer_cpr_number)
);

create index lease_car_reg_number_idx
    on lease (lease_car_reg_number);

create index lease_customer_cpr_number_idx
    on lease (lease_customer_cpr_number);


create table damage_report
(
    damage_report_id                 int auto_increment
        primary key,
    damage_report_date               date         not null,
    damage_report_description        varchar(100) not null,
    damage_report_car_chassis_number varchar(45)  not null,
    constraint damage_report_car_chassis_number
        foreign key (damage_report_car_chassis_number) references car (car_chassis_number)
);

create index damage_report_car_chassis_number_idx
    on damage_report (damage_report_car_chassis_number);


create table damage
(
    damage_id          int auto_increment
        primary key,
    damage_description varchar(200) not null,
    damage_price       int          not null,
    damage_report_id   int          not null,
    constraint damage_report_id
        foreign key (damage_report_id) references damage_report (damage_report_id)
            on delete cascade
);

create index damage_report_id_idx
    on damage (damage_report_id);


