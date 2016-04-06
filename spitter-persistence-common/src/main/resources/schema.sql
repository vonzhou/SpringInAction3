使用MySQL数据库:

create database spitter;
use database spitter;

drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id int not null auto_increment primary key,
  username varchar(25) not null,
  password varchar(25) not null,
  fullname varchar(100),
  email varchar(50),
  update_by_email boolean
);

create table spittle (
  id int not null auto_increment primary key,
  spitter_id int not null,
  spittleText varchar(2000) not null,
  postedTime date not null,
  foreign key (spitter_id) references spitter(id)
);
