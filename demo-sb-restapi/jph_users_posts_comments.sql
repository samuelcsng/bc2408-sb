show databases;
use bootcamp_2408_test;
show tables;

select * from users;
select count(*) from users;
select * from posts;
select count(*) from posts;
select * from comments;
select count(*) from comments;
select * from companies;
select count(*) from companies;

drop table if exists users;
drop table if exists posts;
drop table if exists comments;
drop table if exists companies;
drop table if exists addresses;
drop table if exists geos;

select * from comments where id = 999;
delete from comments where id = 1;
select * from posts where id = 1;
delete from posts where id = 1;
insert into comments values (999, 9, "abcTesting", "abc@gmail.com", "naming nane");
