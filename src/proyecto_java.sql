DROP DATABASE Inscripciones;
CREATE DATABASE Inscripciones DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;;
USE Inscripciones;

CREATE TABLE Usuarios(
    id int NOT NULL UNIQUE AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE maestros(
    nomina int NOT NULL UNIQUE,
    nombre varchar(100) NOT NULL,
    telefono varchar(50),
    email varchar(50) NOT NULL,
    PRIMARY KEY(nomina)
);

CREATE TABLE salones(
    id int NOT NULL UNIQUE AUTO_INCREMENT,
    numero_salon int NOT NULL,
    capacidad int NOT NULL,
    departamento varchar(50) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE unique_key (departamento, numero_salon)
);

CREATE TABLE horarios(
    id int NOT NULL UNIQUE AUTO_INCREMENT,
    dias varchar(20) NOT NULL,
    hora varchar(20) NOT NULL,
    duracion int NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE materias(
    clave varchar(10) NOT NULL UNIQUE,
    nombre varchar(50) NOT NULL,
    horas_laboratorio int,
    PRIMARY KEY(clave)
);

CREATE TABLE grupos(
    id int NOT NULL UNIQUE AUTO_INCREMENT,
    materia_id varchar(10) NOT NULL,
    grupo int NOT NULL,
    idioma int NOT NULL DEFAULT 0,
    honors boolean NOT NULL DEFAULT false,
    PRIMARY KEY(id),
    UNIQUE KEY unique_key (materia_id, grupo),
    FOREIGN KEY(materia_id) REFERENCES materias(clave)
);

CREATE TABLE grupos_details(
    grupo_id int NOT NULL,
    maestro_id int NOT NULL,
    salon_id int NOT NULL,
    horario_id int NOT NULL, 
    laboratorio boolean NOT NULL DEFAULT false,
    porcentaje decimal(1, 1) NOT NULL,
    PRIMARY KEY(grupo_id, maestro_id, salon_id, horario_id),
    UNIQUE KEY maestro_unique_horario (maestro_id, horario_id),
    UNIQUE KEY maestro_unique_salon (maestro_id, salon_id),
    FOREIGN KEY(grupo_id) REFERENCES grupos(id),
    FOREIGN KEY(maestro_id) REFERENCES maestros(nomina),
    FOREIGN KEY(salon_id) REFERENCES salones(id),
    FOREIGN KEY(horario_id) REFERENCES horarios(id)
);