insert into plat (id, nom, prix) values (1, 'Magret de canard', 1300); 
insert into plat (id, nom, prix) values (2, 'Moules-frites', 1300); 
insert into plat (id, nom, prix) values (3, 'Couscous', 1600);
insert into plat (id, nom, prix) values (4, 'Blanquette de veau', 1500); 
insert into plat (id, nom, prix) values (5, 'Côte de boeuf', 1100); 
insert into plat (id, nom, prix) values (6, 'Gigot d''agneau', 2500);

-- ingredients
insert into ingredient(id, nom) values (1, 'Magret de canard gras');
insert into ingredient(id, nom) values (2, 'Vinaigre balsamique');
insert into ingredient(id, nom) values (3, 'Sel');
insert into ingredient(id, nom) values (4, 'Moule');
insert into ingredient(id, nom) values (5, 'Pomme Golden');
insert into ingredient(id, nom) values (6, 'Veau');
insert into ingredient(id, nom) values (7, 'Bœuf');
insert into ingredient(id, nom) values (8, 'Agneau');
insert into ingredient(id, nom) values (9, 'Beurre');
insert into ingredient(id, nom) values (10, 'Ail');
insert into ingredient(id, nom) values (11, 'Persil');
insert into ingredient(id, nom) values (12, 'Thym');
insert into ingredient(id, nom) values (13, 'Poivre');
insert into ingredient(id, nom) values (14, 'Vin blanc sec');
insert into ingredient(id, nom) values (15, 'Cidre');

-- Magret de canard
insert into plat_ingredient(plat_id, ingredient_id) values (1, 1);
insert into plat_ingredient(plat_id, ingredient_id) values (1, 3);
insert into plat_ingredient(plat_id, ingredient_id) values (1, 5);
insert into plat_ingredient(plat_id, ingredient_id) values (1, 15);
insert into plat_ingredient(plat_id, ingredient_id) values (1, 9);

-- Moules-frites
insert into plat_ingredient(plat_id, ingredient_id) values (2, 4);
insert into plat_ingredient(plat_id, ingredient_id) values (2, 9);
insert into plat_ingredient(plat_id, ingredient_id) values (2, 11);
insert into plat_ingredient(plat_id, ingredient_id) values (2, 12);
insert into plat_ingredient(plat_id, ingredient_id) values (2, 13);
insert into plat_ingredient(plat_id, ingredient_id) values (2, 14);