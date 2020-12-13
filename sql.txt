/*
drop table if exists entityone
drop table if exists entitytwo

Create Table entityone(
	id int primary key not null,
	my_data varchar(32)
)

Create Table entitytwo(
	id int primary key not null,
	my_time datetime,
	my_string varchar(32),
	my_boolean bit,
	entity_one_id int,
	Foreign Key(entity_one_id) References entityone(id)
)

insert into entityone values(1,'my-data data')
insert into entitytwo values(1,'2020-02-02', 'string1',0,1)
insert into entitytwo values(2,'2020-03-03', 'string2',1,1)
*/