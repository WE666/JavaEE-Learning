create database spring character set utf8 collate utf8_general_ci;

use spring;

create table T_EMP(
	id int(11) not null primary key,
	name varchar(255),
	email varchar(255),
    address varchar(255),
    telephone varchar(255)
)character set utf8 collate utf8_general_ci;