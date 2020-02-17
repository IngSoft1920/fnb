INSERT INTO restaurante (nombre,hora_apertura,hora_clausura) VALUES
	('Mamma Mia','13:00','23:00'),
    ('Boruto','12:00','23:00');
    
INSERT INTO mesa (num_mesa,capacidad,restaurante_id) VALUES
	(1,4,1),
    (2,4,1),
    (3,4,1),
    (4,4,1),
    (5,5,1),
    (6,4,1),
    (7,6,1),
    (8,6,1),
    (9,8,1),
    (10,2,1),
    (11,2,1),
    (1,4,2),
    (2,4,2),
    (3,4,2),
    (4,4,2),
    (5,5,2),
    (6,4,2),
    (7,6,2),
    (8,6,2),
    (9,8,2),
    (10,2,2),
    (11,2,2);

INSERT INTO menu (disponible, titulo, restaurante_id) VALUES
	(TRUE, 'Ciao Bella', 1),
    (TRUE, 'Sakura', 2);


INSERT INTO plato (tipo,num_plato,nombre,elemcomanda_id) VALUES
	('Entrante',1,'Croquetas de Queso Asiago y Jamon Dulce', 1),
    ('Entrante',2,'Bruschetta',2),
    ('Entrante',3, 'Carpaccio',3),
    ('Principal',4,'Penne al Pesto',4),
    ('Principal',5,'Spaghetti Carbonara',5),
    ('Principal',6,'Pizza Quattro Stagioni',6),
    ('Postre',7,'Tiramisu',7),
    ('Postre',8,'Tarta de Queso',8),
    ('Entrante',1,'Rollito de primavera',9),
    ('Principal',2,'Pollo almendrado',10);

INSERT INTO item(tipo,nombre,elemcomanda_id)VALUES
	('Refresco','CocaCola',11),
    ('Refresco','Fanta',12),
    ('Alcohol','Cerveza',13),
    ('Alcohol','Vino',14),
    ('Postre','Cafe',15);

INSERT INTO plato_menu VALUES
	(1,1,9.9),
    (2,1,11.9),
    (3,1,16.9),
    (4,1,12.9),
    (5,1,13.5),
    (6,1,11.9),
    (7,1,4.9),
    (8,1,5.5),
    (9,2,1.4),
    (10,2,4.3),
    (8,2,5.5);

INSERT INTO item_menu VALUES
	(1,1,1.8),
    (1,2,1.8),
    (2,1,1.8),
    (2,2,1.8),
    (3,1,2.5),
    (3,2,2.5),
    (4,1,15.0),
    (4,2,15.0),
    (5,1,1.9),
    (5,2,1.9);


INSERT INTO ingrediente(nombre) VALUES
	('Pan'),
    ('Jamón'),
    ('Queso Asiago'),
    ('Huevo'),
    ('Leche'),
    ('Aceite'),
    ('Tomate'),
    ('Ajo'),
    ('Solomillo de buey'),
    ('Queso parmesano'),
    ('Macarrones Penne'),
    ('Piñones'),
    ('Albahaca'),
    ('Queso de oveja'),
    ('Chalota'),
    ('Spagueti'),
    ('Levadura'),
    ('Harina'),
    ('Queso Mozzarella'),
    ('Champiñone'),
    ('Alcachofa'),
    ('Aceitunas'),
    ('Azucar'),
    ('Queso mascarpone'),
    ('Galleta'),
    ('Cafe'),
    ('Cacao'),
    ('Mantequilla'),
    ('Gelatina en polvo'),
    ('Queso cremoso'),
    ('Nata liquida'),
    ('Mermelada frambuesa'),
    ('Vinagre de arroz'),
    ('Salsa de soja'),
    ('Ketchup'),
    ('Reepollo'),
    ('Apio'),
    ('Cebolleta'),
    ('Pimiento verde'),
    ('Zanahoria'),
    ('Langostino'),
    ('Hojas rollitos'),
    ('Pollo'),
    ('Maicena'),
    ('Almendra');

INSERT INTO plato_ingrediente VALUES 
	(1,1,85,'g'),
    (1,2,150,'g'),
    (1,3,90,'g'),
    (1,4,1,'unidad'),
    (1,5,60,'ml'),
    (1,6,340,'ml'),
    (2,1,100,'g'),
    (2,7,500,'g'),
    (2,8,1,'unidad'),
    (3,9,300,'g'),
    (3,6,40,'ml'),
    (3,10,100,'g'),
    (4,11,100,'g'),
    (4,10,80,'g'),
    (4,12,30,'g'),
    (4,13,80,'g'),
    (4,6,170,'ml'),
    (5,10,60,'g'),
    (5,14,30,'g'),
    (5,15,30,'g'),
    (5,2,150,'g'),
    (5,6,30,'ml'),
    (5,16,350,'g'),
    (5,4,4,'unidad'),
    (6,17,20,'g'),
    (6,18,400,'g'),
    (6,6,40,'ml'),
    (6,19,125,'g'),
    (6,20,50,'g'),
    (6,21,50,'g'),
    (6,22,30,'g'),
    (6,2,30,'g'),
    (7,4,3,'unidad'),
    (7,23,130,'g'),
    (7,24,500,'g'),
    (7,25,300,'g'),
    (7,26,350,'g'),
    (7,27,20,'g'),
    (8,25,200,'g'),
    (8,28,80,'g'),
    (8,29,90,'g'),
    (8,30,400,'g'),
    (8,31,200,'g'),
    (8,23,40,'g'),
    (8,32,200,'g'),
    (9,23,60,'g'),
    (9,33,40,'g'),
    (9,34,10,'g'),
    (9,35,20,'g'),
    (9,36,250,'g'),
    (9,37,20,'g'),
    (9,38,150,'g'),
    (9,39,50,'g'),
    (9,40,150,'g'),
    (9,41,100,'g'),
    (9,42,12,'unidad'),
    (9,6,340,'ml'),
    (10,43,800,'g'),
    (10,44,100,'g'),
    (10,45,300,'g'),
    (10,6,330,'ml');
    
INSERT INTO inventario 
SELECT NULL, 'ElMejorSL'
FROM ingrediente; 

#ALTER TABLE inventario auto_increment =45;

INSERT INTO inventario VALUES
	(NULL,'ElMejorSL'),(NULL,'ElMejorSL'),(NULL,'ElMejorSL'),(NULL,'ElMejorSL'),(NULL,'ElMejorSL');
    
INSERT INTO ingrediente_inventario
SELECT  ingrediente_id, ingrediente_id, (SUM(cantidad)*20),MIN(unidad)
FROM plato_ingrediente
GROUP BY ingrediente_id;

INSERT INTO item_inventario
SELECT item_id, (item_id+45),50
FROM item;

#DATOS TESTING
INSERT INTO ubicacion VALUES (NULL),(NULL);

INSERT INTO mesa_ubicacion VALUES (1,1);

INSERT INTO habitacion_ubicacion VALUES (1,2);

INSERT INTO comanda VALUES (NULL,FALSE,1,3,CURDATE()), (NULL,FALSE,2,NULL,'2020-02-15 23:30:00');

INSERT INTO tarea_comanda_ubicacion VALUES (1,1,1),(2,2,2);

INSERT INTO comanda_elemComanda VALUES 
	(1,1),(1,2),(1,4),(1,7),
    (2,15);

INSERT INTO servicio_comanda VALUES
	(1,1,CURDATE()),(2,2,'2020-02-15 23:30:00');