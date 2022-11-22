create table station_user 
(
    id int not null primary key
);

insert into station_user 
(
    id
) 
values 
(1), (2), (3), (4);

create table branch_station 
(
    id int not null primary key,
    branch_id int not null
);

insert into branch_station 
(
    id, branch_id
) 
values 
(1, 20),
(2, 23),
(3, 25),
(4, 26);

create table station 
(
    id int not null primary key,
    branch_id int not null references branch_station (id),
    station_name varchar(50) not null,
    station_master int references station_user (id)
);

insert into station 
(
    id,
    branch_id,
    station_name,
    station_master
) 
values 
(1, 1, 'Boringham', 1),
(2, 2, 'Metchum', 2),
(3, 3, 'Coulding', 4),
(4, 4, 'Jounty', 3);