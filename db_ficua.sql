CREATE SCHEMA `bdficua` ;

CREATE TABLE `bdficua`.`usuario_registrado` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `contraseña` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Id`));

CREATE TABLE `bdficua`.`vendedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `departamento` VARCHAR(25) NOT NULL,
  `ciudad` VARCHAR(10) NOT NULL,
  `direccion` VARCHAR(10) NOT NULL,
  `latitud` VARCHAR(5) NOT NULL,
  `longuitud` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bdficua`.`comprador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `departamento` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bdficua`.`factura` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_vendedor` INT NOT NULL,
  `id_comprador` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `descuento` FLOAT NOT NULL,
  `estado` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bdficua`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_vendedor` INT NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `valor_unitario` FLOAT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `foto` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `bdficua`.`reseña` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_factura` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `calificacion` INT NOT NULL,
  `comentario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bdficua`.`linea_factura` (
  `id_factura` INT NOT NULL AUTO_INCREMENT,
  `id_producto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `valor_unitario` FLOAT NOT NULL,
  PRIMARY KEY (`id_factura`));