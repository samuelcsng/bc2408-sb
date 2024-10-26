show databases;
use bc_2408_bc_forum_ex3;
show tables;

-- SET FOREIGN_KEY_CHECKS = 1; 

-- drop tables in sequence considering the foreign keys and primary keys relationship
drop table if exists comments;
drop table if exists posts;
drop table if exists geos;
drop table if exists addresses;
drop table if exists companies;
drop table if exists users;

select count(*) from users;
select count(*) from posts;
select count(*) from comments;
select count(*) from companies;
select count(*) from addresses;
select count(*) from geos;

