create table basket (
    id integer not null auto_increment,
    item_count integer,
    item_id integer,
    item_size varchar(255),
    user_id integer,
    primary key (id));

create table items (
    id integer not null auto_increment,
    cover_link longtext,
    item_name longtext,
    price integer not null,
    description varchar(1024),
    type_id integer not null,
    primary key (id));

create table favs (
    id integer not null auto_increment,
    item_id integer,
    user_id integer,
    primary key (id));

create table types (
    id integer not null auto_increment,
    type_name varchar(255) not null,
    primary key (id));

create table user (
    id integer not null auto_increment,
    active bit not null,
    password varchar(255),
    username varchar(255),
    primary key (id));

create table user_role (
    user_id integer not null,
    roles integer);

alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);