insert into course(id, fullname, last_updated_date, created_date) values (10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into course(id, fullname, last_updated_date, created_date)  values (10002, 'Spring in 50 steps', sysdate(), sysdate());
insert into course(id, fullname, last_updated_date, created_date)  values (10003, 'Microservices in 50 steps', sysdate(), sysdate());

insert into passport(id, number) values(40001, 'AA1234');
insert into passport(id, number) values(40002, 'FD2345');
insert into passport(id, number) values(40003, 'GT2423');


insert into student(id, name, passport_id) values(20001, 'Anik', 40001);
insert into student(id, name, passport_id) values(20002, 'John', 40003);
insert into student(id, name, passport_id) values(20003, 'Disha', 40002);



insert into review(id, ratings, description, course_id) values(80001, '5', 'Very Good Course', 10001);
insert into review(id, ratings, description, course_id) values(80002, '4.5', 'Wonderful Course', 10001);
insert into review(id, ratings, description, course_id) values(80003, '4', 'Moderate Course', 10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);