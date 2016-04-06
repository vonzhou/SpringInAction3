使用MySQL数据库:

create database spitter;
use database spitter;

drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id int not null auto_increment primary key,
  username varchar(25) not null,
  password varchar(25) not null,
  fullname varchar(100) not null,
  email varchar(50) not null,
  update_by_email boolean not null
);

create table spittle (
  id int not null auto_increment primary key,
  spitter_id int not null,
  spittleText varchar(2000) not null,
  postedTime date not null,
  foreign key (spitter_id) references spitter(id)
);
