create table t_major
(
    id integer auto_increment,
    name varchar(50),
    university varchar(50),
    college varchar(50),
    office varchar(10),
    primary key (id)
);

create table t_student
(
    id integer auto_increment,
    lastname varchar(50),
    firstname varchar(50),
    mail varchar(50),
    year integer,
    id_major integer,
    primary key(id),
    foreign key (id_major) references t_major(id)
);



