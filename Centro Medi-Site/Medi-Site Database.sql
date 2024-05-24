-- Crear la base de datos
CREATE DATABASE mediSite;

-- Seleccionar la base de datos
USE mediSite;

CREATE TABLE historial_medico (
    historial_id BIGINT PRIMARY KEY
);

CREATE TABLE usuario (
    numero_ss VARCHAR(15),
    telefono VARCHAR(12),
    user_id BIGINT PRIMARY KEY,
    centrosalud_medico_id BIGINT,
    historial_medico BIGINT,
    FOREIGN KEY (historial_medico) REFERENCES historial_medico(historial_id)
);

CREATE TABLE tipocita (
    tipo_de_cita_model BIGINT PRIMARY KEY,
    descripcion VARCHAR(100),
    nombre VARCHAR(50)
);

CREATE TABLE timeslot (
    timeslot_id BIGINT PRIMARY KEY,
    hora_fin INT,
    hora_inicio INT
);

CREATE TABLE cita (
    cita_modelid BIGINT PRIMARY KEY,
    comentario VARCHAR(100),
    fecha DATETIME,
    timeslot_id BIGINT,
    tipocita BIGINT,
    usuario BIGINT,
    FOREIGN KEY (timeslot_id) REFERENCES timeslot(timeslot_id),
    FOREIGN KEY (tipocita) REFERENCES tipocita(tipo_de_cita_model),
    FOREIGN KEY (usuario) REFERENCES usuario(user_id)
);

CREATE TABLE receta (
    receta_id BIGINT PRIMARY KEY,
    descripcio VARCHAR(255),
    fecha DATE,
    historial_id BIGINT,
    FOREIGN KEY (historial_id) REFERENCES historial_medico(historial_id)
);

CREATE TABLE generic_user_model (
    rol VARCHAR(31),
    user_id BIGINT PRIMARY KEY,
    apellidos VARCHAR(50),
    mail VARCHAR(50),
    nombre VARCHAR(50),
    password VARCHAR(50),
    status VARCHAR(20),
    username VARCHAR(50)
);

CREATE TABLE admin (
    user_id BIGINT PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES generic_user_model(user_id)
);

CREATE TABLE medico (
    user_id BIGINT PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES generic_user_model(user_id)
);

CREATE TABLE centrosalud (
    centro_salud_id BIGINT PRIMARY KEY,
    direccion VARCHAR(50),
    hora_apertura INT,
    hora_cierre INT,
    nombre VARCHAR(50),
    telefono VARCHAR(15),
    urgencias BIT
);

CREATE TABLE centrosaludmedico (
    centro_salud_medico_modelid BIGINT PRIMARY KEY,
    hora_fin INT,
    hora_inicio INT,
    centrosalud_id BIGINT,
    medico_id BIGINT,
    FOREIGN KEY (centrosalud_id) REFERENCES centrosalud(centro_salud_id),
    FOREIGN KEY (medico_id) REFERENCES medico(user_id)
);

