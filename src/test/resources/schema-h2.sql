create table plat (
id int(11) not null primary key auto_increment, nom varchar(100) not null unique,
prix int(7) not null
);

create table ingredient (
id int(11) not null primary key auto_increment,
nom varchar(100) not null unique );

create table plat_ingredient (
plat_id int(11) not null,
ingredient_id int(11) not null,
foreign key (plat_id) references plat(id),
foreign key (ingredient_id) references ingredient(id), primary key (plat_id, ingredient_id)
);