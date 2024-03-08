-- Inserts de la tabla tipo_dane
INSERT INTO institucion.tipo_dane(id,descripcion) VALUES (1,'Pais'),(2,'Ciudad'),(3,'Departamento');

-- Inserts de la tabla tipo_documento
INSERT INTO institucion.tipo_documento VALUES (1,'Cedula de Ciudadania'),(2,'Tarjeta de Identidad'),(3,'Cedula de Extranjeria');

-- Inserts de la tabla dane
INSERT INTO institucion.dane VALUES (1,'Colombia',1),(2,'Chile',1),(3,'Valle del Cauca',3),(4,'Antofagastaaa',3),(5,'Cali',2),(6,'Calama',2);

-- Inserts de la tabla grado
INSERT INTO institucion.grado VALUES (1,'Primero'),(2,'Tercero'),(3,'Quinto'),(4,'Septimo'),(5,'Quinto'),(6,'Sexto'),(7,'Septimo'),(8,'Octavo'),(9,'Novenos');

-- Inserts de la tabla tipo_documento
INSERT INTO institucion.tipo_documento VALUES (1,'Cedula de Ciudadania'),(2,'Tarjeta de Identidad'),(3,'Cedula de Extranjeria');

--Inserts de la tabla docente
INSERT INTO institucion.docente
(id,id_tipodocumento,numero_documento,nombres,apellidos,fecha_nacimiento,grado_escolaridad,id_grado_responsable,email, celular, fijo)
VALUES
(1,1,'1143877351','Luis','Rivera','19-02-1999','Postgrado',4,'r23felipe@gmail.com','310-38-84','315-277-97-61'),
(2,1,'29842118','Bernarda','Molina','16-08-1972','Postgrado',1,'bernarda@gmail.com','4223891','310-337-93-92'),
(3,1,'64294153','Eduardo','Rojas','05-05-1970','Postgrado',2,'eduardo@gmail.com','3742050','315-466-27-29');

-- Inserts de la tabla estudiante
INSERT INTO institucion.estudiante
(id,id_tipodocumento, numero_documento,nombres,apellidos,fecha_nacimiento, id_dane, id_grado,direccion,email, celular, fijo)
VALUES
(1,2,'99021902949','Anggelo','Moncada','01-01-2001',2,5,'Diag 26 J #77-57','anggelo@gmail.com','300-00-00','311-300-10-10'),
(2,2,'99021902900','Diego','Bocanegra','01-01-1998',4,5,'Cra 7s #42-63','diego@gmail.com','300-00-29','311-399-10-20'),
(3,2,'9802190750','Oscar','Naranjo','01-08-1998',3,5,'Cra 8 #63-80','oscar@gmail.com','310-80-29','300-400-50-20'),
(4,1,'29843220','Bryan','Portillo','01-10-2004',1,6,'Avenida las Americas','bryan@gmail.com','No aplica','300-110-99-99'),
(5,1,'1116269948','Andres','Bedoya','12-26-1995',1,1,'Cra 42a #23-39','piperomero1226@gmail.com','2305539','3156624815'),
(6,1,'1116266973','Juan David','Barbosa','8-4-1995',1,1,'Transv 9 #22-42','juandabar22@hotmail.com','2305539','3156624815');

-- Inserts de la tabla asignatura
INSERT INTO institucion.asignatura VALUES (1,'Matematicas',1),(2,'Español',1),(3,'Religión',2),(4,'Etica',2),(5,'Fisica 2',3);

-- Inserts de la tabla estudiante_asignatura
INSERT INTO institucion.estudiante_asignatura VALUES (4.5,1,1,1),(5,1,1,2),(0,1,1,3),(1.5,1,2,1),(3.1,1,2,2),(4.2,1,2,3),(4,1,3,1),(4,1,3,2),(4,1,3,3),(5,1,4,1),(1.2,1,4,2),(1.7,1,4,3);