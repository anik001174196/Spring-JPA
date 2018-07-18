create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)

);

insert into person (id, name, location, birth_date) values (10001, 'Anik', 'Chittagong', sysdate());
insert into person (id, name, location, birth_date) values (10002, 'Disha', 'Mymensingh', sysdate());
insert into person (id, name, location, birth_date) values (10003, 'JOhn', 'Canada', sysdate());
select * from person;