
create table if not exists drone (
	id int primary key Auto_increment,
	serial varchar(100) not null,
	model enum('Lightweight', 'Widdleweight', 'Cruiserweight', 'Heavyweight') not null,
	battery int not null,
	state enum('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING')
);

create table if not exists medication (
	id int primary key Auto_increment,
	name varchar(100) not null,
	weight int not null,
	code varchar(100) not null,
	image_url varchar(260) not null,
	drone_id int,
	foreign key (drone_id) references drone (id) 
); 