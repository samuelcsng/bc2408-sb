show databases;
use bc_2408_bc_forum;
show tables;

drop table if exists comment;
drop table if exists post;
drop table if exists user;
drop table if exists company;
drop table if exists address;
drop table if exists geo;

select count(*) from user;
select count(*) from post;
select count(*) from comment;
select count(*) from company;
select count(*) from address;
select count(*) from geo;