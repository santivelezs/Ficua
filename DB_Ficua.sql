CREATE DATABASE ficua;
USE ficua;
CREATE TABLE usuarioRegistrado(
    email VARCHAR(100),
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(20),
    password VARCHAR(100),
    PRIMARY KEY(email)
);

CREATE TABLE vendedor(
    id_user VARCHAR(100),
    nombreTienda VARCHAR(100),
    fechaRegistro DATE DEFAULT (CURRENT_DATE),
    depto VARCHAR(50),
    ciudad VARCHAR(50),
    direccion VARCHAR(100),
    latitud FLOAT,
    longitud FLOAT,
    PRIMARY KEY(id_user),
    FOREIGN KEY(id_user)
    REFERENCES usuarioRegistrado(email)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);