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
select * from users;
select * from users where id = 1;
select count(*) from posts;
select * from posts;
select * from posts where id = 1;
select count(*) from comments;
select * from comments;
select * from comments where id = 1;
select count(*) from companies;
select * from companies;
select * from companies where id = 1;
select count(*) from addresses;
select * from addresses;
select * from addresses where id = 1;
select count(*) from geos;
select * from geos;
select * from geos where id = 1;
