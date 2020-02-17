#///// CREACIÓN DE LA BASE DE DATOS ///// 
CREATE DATABASE fnb DEFAULT CHARACTER SET utf8;

#///// CREACIÓN DE TABLAS //////
CREATE TABLE mesa(

	mesa_id INT auto_increment,
    num_mesa INT,
    capacidad INT,
    restaurante_id INT,
    
    PRIMARY KEY(mesa_id)
);


CREATE TABLE mesa_ubicacion(

	mesa_id INT,
    ubicacion_id INT,
    
    PRIMARY KEY(mesa_id,ubicacion_id)
);

CREATE TABLE ubicacion(

	ubicacion_id INT auto_increment,
    
    PRIMARY KEY(ubicacion_id)
);


CREATE TABLE habitacion_ubicacion(

	habitacion_id INT,
    ubicacion_id INT,
     
    PRIMARY KEY(habitacion_id,ubicacion_id)
);

CREATE TABLE comanda(

	comanda_id INT auto_increment,
    estado_acabado BOOLEAN,
    ubicacion_id INT,
    tarea_cocinero_id INT,
    hora DATETIME,
    
    PRIMARY KEY(comanda_id)
);

CREATE TABLE tarea_comanda_ubicacion(

	tarea_id INT,
    comanda_id INT,
	ubicacion_id INT,
    
    PRIMARY KEY(tarea_id,comanda_id,ubicacion_id)
);

CREATE TABLE servicio_comanda(

	servicio_id INT,
	comanda_id INT,
    fecha_hora DATETIME,
    
    PRIMARY KEY(servicio_id,comanda_id,fecha_hora)
);

CREATE TABLE comanda_elemComanda(

	comanda_id INT,
    elemComanda_id INT,
    
    PRIMARY KEY(comanda_id,elemComanda_id)
);

CREATE TABLE elemComanda(

    elemComanda_id INT auto_increment,
    
    PRIMARY KEY(elemComanda_id)
);


CREATE TABLE plato(

	plato_id INT auto_increment,
    tipo VARCHAR(150),
    num_plato INT,
    nombre VARCHAR(150),
    elemComanda_id INT,
    
    PRIMARY KEY(plato_id)
);

CREATE TABLE item(

	item_id INT auto_increment,
    tipo VARCHAR(150),
    nombre VARCHAR(150),
    elemComanda_id INT,
    
    PRIMARY KEY(item_id)
);

CREATE TABLE plato_menu(

	plato_id INT,
    menu_id INT,
    precio FLOAT,
    
    PRIMARY KEY(plato_id,menu_id)
);

CREATE TABLE item_menu(

	item_id INT,
    menu_id INT,
    precio FLOAT,
    
    PRIMARY KEY(item_id,menu_id)
);

CREATE TABLE menu(

    menu_id INT auto_increment,
    disponible BOOLEAN,
    titulo VARCHAR(150),
    restaurante_id INT,
    
    PRIMARY KEY(menu_id)
);

CREATE TABLE plato_ingrediente(

    plato_id INT,
    ingrediente_id INT,
    cantidad INT,
    unidad VARCHAR(150),
    
    PRIMARY KEY(plato_id,ingrediente_id)
);

CREATE TABLE ingrediente(

    ingrediente_id INT auto_increment,
    nombre VARCHAR(150),
    
    PRIMARY KEY(ingrediente_id)
);

CREATE TABLE ingrediente_inventario(

    ingrediente_id INT,
    inventario_id INT,
    cantidad INT,
    unidad VARCHAR(150),
    
    PRIMARY KEY(ingrediente_id,inventario_id)
);

CREATE TABLE item_inventario(

    item_id INT,
    inventario_id INT,
    cantidad INT,
    
    PRIMARY KEY(item_id,inventario_id)
);


CREATE TABLE inventario(

    inventario_id INT auto_increment,
    proveedor VARCHAR(150),
    
    PRIMARY KEY(inventario_id)
);

CREATE TABLE restaurante(

    restaurante_id INT auto_increment,
    nombre VARCHAR(150),
    hora_apertura TIME,
    hora_clausura TIME,
    
    PRIMARY KEY(restaurante_id)
);

#///// CREAR FOREIGN KEYS /////

ALTER TABLE mesa
ADD CONSTRAINT FK_mesa_restaurante_id FOREIGN KEY(restaurante_id) REFERENCES restaurante(restaurante_id)
;

ALTER TABLE mesa_ubicacion
ADD CONSTRAINT FK_mesa_ubicacion_mesa_id FOREIGN KEY(mesa_id) REFERENCES mesa(mesa_id),
ADD CONSTRAINT FK_mesa_ubicacion_ubicacion_id  FOREIGN KEY(ubicacion_id) REFERENCES ubicacion(ubicacion_id)
;

ALTER TABLE habitacion_ubicacion
ADD CONSTRAINT FK_habitacion_ubicacion_ubicacion_id  FOREIGN KEY(ubicacion_id) REFERENCES ubicacion(ubicacion_id)
;

ALTER TABLE comanda
ADD CONSTRAINT FK_comanda_ubicacion_id FOREIGN KEY(ubicacion_id) REFERENCES ubicacion(ubicacion_id)
;

ALTER TABLE tarea_comanda_ubicacion
ADD CONSTRAINT FK_tarea_comanda_ubicacion_comanda_id FOREIGN KEY(comanda_id) REFERENCES comanda(comanda_id),
ADD CONSTRAINT FK_tarea_comanda_ubicacion_ubicacion_id FOREIGN KEY(ubicacion_id) REFERENCES comanda(comanda_id)
;

ALTER TABLE servicio_comanda
ADD CONSTRAINT FK_servicio_comanda_comanda_id FOREIGN KEY(comanda_id) REFERENCES comanda(comanda_id)
;

ALTER TABLE comanda_elemComanda
ADD CONSTRAINT FK_comanda_elemComanda_comanda_id FOREIGN KEY(comanda_id) REFERENCES comanda(comanda_id),
ADD CONSTRAINT FK_comanda_elemComanda_elemComanda_id FOREIGN KEY(elemComanda_id) REFERENCES elemComanda(elemComanda_id)
;

ALTER TABLE plato
ADD CONSTRAINT FK_plato_elemComanda_id FOREIGN KEY(elemComanda_id) REFERENCES elemComanda(elemComanda_id)
;

ALTER TABLE item
ADD CONSTRAINT FK_item_elemComanda_id FOREIGN KEY(elemComanda_id) REFERENCES elemComanda(elemComanda_id)
;

ALTER TABLE plato_menu
ADD CONSTRAINT FK_plato_menu_plato_id FOREIGN KEY(plato_id) REFERENCES plato(plato_id),
ADD CONSTRAINT FK_plato_menu_menu_id FOREIGN KEY(menu_id) REFERENCES menu(menu_id)
;

ALTER TABLE item_menu
ADD CONSTRAINT FK_item_menu_item_id FOREIGN KEY(item_id) REFERENCES item(item_id),
ADD CONSTRAINT FK_item_menu_menu_id FOREIGN KEY(menu_id) REFERENCES menu(menu_id)
;

ALTER TABLE menu
ADD CONSTRAINT FK_menu_restaurante_id FOREIGN KEY(restaurante_id) REFERENCES restaurante(restaurante_id)
;

ALTER TABLE plato_ingrediente
ADD CONSTRAINT FK_plato_ingrediente_plato_id FOREIGN KEY(plato_id) REFERENCES plato(plato_id),
ADD CONSTRAINT FK_plato_ingrediente_ingrediente_id FOREIGN KEY(ingrediente_id) REFERENCES ingrediente(ingrediente_id)
;

ALTER TABLE item_inventario
ADD CONSTRAINT FK_item_inventario_item_id FOREIGN KEY(item_id) REFERENCES item(item_id),
ADD CONSTRAINT FK_item_inventario_inventario_id FOREIGN KEY(inventario_id) REFERENCES inventario(inventario_id)
;

ALTER TABLE ingrediente_inventario
ADD CONSTRAINT FK_ingrediente_inventario_ingrediente_id FOREIGN KEY(ingrediente_id) REFERENCES ingrediente(ingrediente_id),
ADD CONSTRAINT FK_ingrediente_inventario_inventario_id FOREIGN KEY(inventario_id) REFERENCES inventario(inventario_id)
;

/*
DROP TRIGGER IF EXISTS `fnb`.`plato_BEFORE_INSERT`;

DELIMITER $$
USE `fnb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `fnb`.`plato_BEFORE_INSERT` BEFORE INSERT ON `plato` FOR EACH ROW
BEGIN
INSERT INTO elemcomanda VALUES (null);
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS `fnb`.`item_BEFORE_INSERT`;

DELIMITER $$
USE `fnb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `fnb`.`item_BEFORE_INSERT` BEFORE INSERT ON `item` FOR EACH ROW
BEGIN
INSERT INTO elemcomanda VALUES (null);
END$$
DELIMITER ;

*/