-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: institucion
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignatura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `id_docente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKboc041q79ps31wr02i3wurjj6` (`id_docente`),
  CONSTRAINT `FKboc041q79ps31wr02i3wurjj6` FOREIGN KEY (`id_docente`) REFERENCES `docente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,'Matematicas',1),(2,'Español',1),(3,'Religión',2),(4,'Etica',2),(5,'Fisica 2',3);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dane`
--

DROP TABLE IF EXISTS `dane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dane` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `id_tipodane` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnnpqn8njj00c37p6ifo4s8ijq` (`id_tipodane`),
  CONSTRAINT `FKnnpqn8njj00c37p6ifo4s8ijq` FOREIGN KEY (`id_tipodane`) REFERENCES `tipo_dane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dane`
--

LOCK TABLES `dane` WRITE;
/*!40000 ALTER TABLE `dane` DISABLE KEYS */;
INSERT INTO `dane` VALUES (1,'Colombia',1),(2,'Chile',1),(3,'Valle del Cauca',3),(4,'Antofagastaaa',1),(5,'Cali',2),(6,'Calama',2);
/*!40000 ALTER TABLE `dane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` varchar(255) DEFAULT NULL,
  `fijo` varchar(255) DEFAULT NULL,
  `grado_escolaridad` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `numero_documento` varchar(255) DEFAULT NULL,
  `id_grado_responsable` bigint(20) DEFAULT NULL,
  `id_tipodocumento` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `docente_grado` (`id_grado_responsable`),
  KEY `FK5b2l5l0p8pp6gc459hn2x07nr` (`id_tipodocumento`),
  CONSTRAINT `FK5b2l5l0p8pp6gc459hn2x07nr` FOREIGN KEY (`id_tipodocumento`) REFERENCES `tipo_documento` (`id`),
  CONSTRAINT `docente_grado` FOREIGN KEY (`id_grado_responsable`) REFERENCES `grado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'Rivera','310-38-84','r23felipe@gmail.com','19-02-1999','315-277-97-61','Postgrado','Luis','1143877351',4,1),(2,'Molina','4223891','bernarda@gmail.com','16-08-1972','310-337-93-92','Postgrado','Bernarda','29842118',1,1),(3,'Rojas','3742050','eduardo@gmail.com','05-05-1970','315-466-27-29','Postgrado','Eduardo','64294153',2,1);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` varchar(255) DEFAULT NULL,
  `fijo` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `numero_documento` varchar(255) DEFAULT NULL,
  `id_dane` bigint(20) DEFAULT NULL,
  `id_grado` bigint(20) DEFAULT NULL,
  `id_tipodocumento` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkkafcqfkk0iqpydqkiin8xqxx` (`id_dane`),
  KEY `FKm7ah3oej75rlyjfk5gxarbk1q` (`id_grado`),
  KEY `FK6b0j7j6y9tpu1i9ajwepn98pb` (`id_tipodocumento`),
  CONSTRAINT `FK6b0j7j6y9tpu1i9ajwepn98pb` FOREIGN KEY (`id_tipodocumento`) REFERENCES `tipo_documento` (`id`),
  CONSTRAINT `FKkkafcqfkk0iqpydqkiin8xqxx` FOREIGN KEY (`id_dane`) REFERENCES `dane` (`id`),
  CONSTRAINT `FKm7ah3oej75rlyjfk5gxarbk1q` FOREIGN KEY (`id_grado`) REFERENCES `grado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Moncada','300-00-00','Diag 26 J #77-57','anggelo@gmail.com','01-01-2001','311-300-10-10','Anggelo','99021902949',2,5,2),(2,'Bocanegra','300-00-29','Cra 7s #42-63','diego@gmail.com','01-01-1998','311-399-10-20','Diego','99021902900',4,5,2),(3,'Naranjo','310-80-29','Cra 8 #63-80','oscar@gmail.com','01-08-1998','300-400-50-20','Oscar','9802190750',3,5,2),(4,'Portillo','No aplica','Avenida las Americas','bryan@gmail.com','01-10-2004','300-110-99-99','Bryan','29843220',1,6,1),(5,'Bedoya','2305539','Cra 42a #23-39','piperomero1226@gmail.com','12-26-1995','3156624815','Andres','1116269948',1,1,1),(6,'Barbosa','2305539','Transv 9 #22-42','juandabar22@hotmail.com','8-4-1995','3156624815','Juan David','1116266973',1,1,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_asignatura`
--

DROP TABLE IF EXISTS `estudiante_asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante_asignatura` (
  `nota` double DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  `id_asignatura` bigint(20) NOT NULL,
  `id_estudiante` bigint(20) NOT NULL,
  PRIMARY KEY (`id_asignatura`,`id_estudiante`),
  KEY `FK6doymdxw9nm6c9ex8rukpcvi3` (`id_estudiante`),
  CONSTRAINT `FK6doymdxw9nm6c9ex8rukpcvi3` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`),
  CONSTRAINT `FKhcbdprh816o2u8sqmdafy2iyr` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_asignatura`
--

LOCK TABLES `estudiante_asignatura` WRITE;
/*!40000 ALTER TABLE `estudiante_asignatura` DISABLE KEYS */;
INSERT INTO `estudiante_asignatura` VALUES (4.5,1,1,1),(5,1,1,2),(0,1,1,3),(1.5,1,2,1),(3.1,1,2,2),(4.2,1,2,3),(4,1,3,1),(4,1,3,2),(4,1,3,3),(5,1,4,1),(1.2,1,4,2),(1.7,1,4,3);
/*!40000 ALTER TABLE `estudiante_asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,'Primero'),(2,'Tercero'),(3,'Quinto'),(4,'Septimo'),(5,'Quinto'),(6,'Sexto'),(7,'Septimo'),(8,'Octavo'),(9,'Novenos'),(10,'Decimo');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_dane`
--

DROP TABLE IF EXISTS `tipo_dane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_dane` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_dane`
--

LOCK TABLES `tipo_dane` WRITE;
/*!40000 ALTER TABLE `tipo_dane` DISABLE KEYS */;
INSERT INTO `tipo_dane` VALUES (1,'Pais'),(2,'Ciudad'),(3,'Departamento'),(5,'Pasaporte');
/*!40000 ALTER TABLE `tipo_dane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'Cedula de Ciudadania'),(2,'Tarjeta de Identidad'),(3,'Cedula de Extranjeria'),(5,'Decimo');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'institucion'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-08 18:01:08
