drop table public.restaurant cascade;
create table public.restaurant (id int4 not null unique, email varchar(25), latitude int8, longitude int8, siteweb varchar(25), telephone varchar(25), primary key (id));
