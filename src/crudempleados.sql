DROP DATABASE IF EXISTS crudempleados;
CREATE DATABASE crudempleados;
USE crudempleados;

CREATE TABLE generos(
idGenero INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20)
);

CREATE TABLE empleados(
    idEmpleado INT AUTO_INCREMENT PRIMARY KEY,
    id_Genero INT NOT NULL,
    nombre VARCHAR(100),
    domicilio VARCHAR(100),
    telefono VARCHAR(12),
    email VARCHAR(100),
    fecha_nacimiento DATE,
    FOREIGN KEY (id_Genero) REFERENCES generos(idGenero)
);

CREATE TABLE login(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE,
    usuario VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(100) NOT NULL
);