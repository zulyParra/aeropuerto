CREATE DATABASE db_aeropuerto;
USE db_aeropuerto;

CREATE TABLE TblHangares
(
    codigo_hangar INT(11) PRIMARY KEY NOT NULL,
    cupo_total INT(11) NOT NULL,
    cupos_disponibles INT(11) NOT NULL,
    cupos_reservados INT(11) NOT NULL
) ;

CREATE TABLE TblContratos
(
    tipo_contrato INT(11) PRIMARY KEY NOT NULL,
    valor_contrato INT(11) NOT NULL
); 

CREATE TABLE TblMetodos_pago
(
    tipo_pago INT(11) PRIMARY KEY NOT NULL,
    nombre VARCHAR(45) NOT NULL
) ;

CREATE TABLE TblPropietarios
(
    cedula VARCHAR(45) PRIMARY KEY NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    tipo_pago INT(11) NOT NULL
) ;

ALTER TABLE TblPropietarios ADD CONSTRAINT fk_tipo_pago FOREIGN KEY(tipo_pago) REFERENCES TblMetodos_pago(tipo_pago);

CREATE TABLE TblAviones
(
    matricula VARCHAR(15) PRIMARY KEY NOT NULL,
    modelo VARCHAR(15) NOT NULL,
    cedula VARCHAR(45) NOT NULL,
    tipo_contrato INT(11) NOT NULL
) ;

ALTER TABLE TblAviones ADD CONSTRAINT fk_cedula FOREIGN KEY(cedula) REFERENCES TblPropietarios(cedula);
ALTER TABLE TblAviones ADD CONSTRAINT fk_tipo_contrato FOREIGN KEY(tipo_contrato) REFERENCES TblContratos(tipo_contrato);

CREATE TABLE TblAviones_Hangares
(
    codigo_hangar INT(11) NOT NULL,
    matricula VARCHAR(15) NOT NULL,
    fecha_ingreso DATETIME NOT NULL,
    numero_celda INT(11) NOT NULL
);

ALTER TABLE TblAviones_Hangares ADD CONSTRAINT fk_codigo_hangar FOREIGN KEY(codigo_hangar) REFERENCES TblHangares(codigo_hangar);
ALTER TABLE TblAviones_Hangares ADD CONSTRAINT fk_matricula FOREIGN KEY(matricula) REFERENCES TblAviones(matricula);

insert into TblMetodos_pago values(1,"credito"),(2,"contado");

select * from TblPropietarios;


