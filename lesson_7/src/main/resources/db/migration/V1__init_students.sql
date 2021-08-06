create table students
(
    id   bigserial primary key,
    name varchar(255),
    age  integer
 );
insert into students (name, age)
values ('Artem', 22),
       ('Vasya', 31),
       ('Dima', 18),
       ('Nastya', 19),
       ('Andrey', 21),
       ('Egor', 21);