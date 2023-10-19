create table `account`(
id bigint not null auto_increment,
number_account varchar(250) not null,
agency varchar(250) not null,
balance decimal(13,2) not null,
limit_account decimal(13,2) not null,
primary key(id)
);