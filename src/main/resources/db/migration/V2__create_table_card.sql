create table card(
id bigint not null auto_increment,
number_card varchar(250) not null unique,
limit_card decimal(13,2) not null,
primary key(id)
);