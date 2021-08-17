-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: db_aeropuerto
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblaviones`
--

DROP TABLE IF EXISTS `tblaviones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblaviones` (
  `matricula` varchar(15) NOT NULL,
  `modelo` varchar(15) NOT NULL,
  `cedula` varchar(45) NOT NULL,
  `tipo_contrato` int NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_cedula` (`cedula`),
  KEY `fk_tipo_contrato` (`tipo_contrato`),
  CONSTRAINT `fk_cedula` FOREIGN KEY (`cedula`) REFERENCES `tblpropietarios` (`cedula`),
  CONSTRAINT `fk_tipo_contrato` FOREIGN KEY (`tipo_contrato`) REFERENCES `tblcontratos` (`tipo_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblaviones`
--

LOCK TABLES `tblaviones` WRITE;
/*!40000 ALTER TABLE `tblaviones` DISABLE KEYS */;
INSERT INTO `tblaviones` VALUES ('6543r','ak897','8888',2),('7676u','kj87','656565',1),('av2345','kjg123','6474',1),('er56','aff32','3322',2);
/*!40000 ALTER TABLE `tblaviones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblaviones_hangares`
--

DROP TABLE IF EXISTS `tblaviones_hangares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblaviones_hangares` (
  `codigo_hangar` int NOT NULL,
  `matricula` varchar(15) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `numero_celda` int NOT NULL,
  KEY `fk_codigo_hangar` (`codigo_hangar`),
  KEY `fk_matricula` (`matricula`),
  CONSTRAINT `fk_codigo_hangar` FOREIGN KEY (`codigo_hangar`) REFERENCES `tblhangares` (`codigo_hangar`),
  CONSTRAINT `fk_matricula` FOREIGN KEY (`matricula`) REFERENCES `tblaviones` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblaviones_hangares`
--

LOCK TABLES `tblaviones_hangares` WRITE;
/*!40000 ALTER TABLE `tblaviones_hangares` DISABLE KEYS */;
INSERT INTO `tblaviones_hangares` VALUES (160,'av2345','2021-08-05 09:11:31',1),(160,'6543r','2021-08-15 06:13:39',1),(160,'7676u','2021-08-16 12:31:12',6),(160,'er56','2021-08-17 09:34:07',7);
/*!40000 ALTER TABLE `tblaviones_hangares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcontratos`
--

DROP TABLE IF EXISTS `tblcontratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcontratos` (
  `tipo_contrato` int NOT NULL,
  `valor_contrato` int NOT NULL,
  PRIMARY KEY (`tipo_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcontratos`
--

LOCK TABLES `tblcontratos` WRITE;
/*!40000 ALTER TABLE `tblcontratos` DISABLE KEYS */;
INSERT INTO `tblcontratos` VALUES (1,60000000),(2,15000000);
/*!40000 ALTER TABLE `tblcontratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblhangares`
--

DROP TABLE IF EXISTS `tblhangares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblhangares` (
  `codigo_hangar` int NOT NULL,
  `cupo_total` int NOT NULL,
  `cupos_disponibles` int NOT NULL,
  `cupos_reservados` int NOT NULL,
  PRIMARY KEY (`codigo_hangar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhangares`
--

LOCK TABLES `tblhangares` WRITE;
/*!40000 ALTER TABLE `tblhangares` DISABLE KEYS */;
INSERT INTO `tblhangares` VALUES (160,16,9,7);
/*!40000 ALTER TABLE `tblhangares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmetodos_pago`
--

DROP TABLE IF EXISTS `tblmetodos_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblmetodos_pago` (
  `tipo_pago` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`tipo_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmetodos_pago`
--

LOCK TABLES `tblmetodos_pago` WRITE;
/*!40000 ALTER TABLE `tblmetodos_pago` DISABLE KEYS */;
INSERT INTO `tblmetodos_pago` VALUES (1,'credito'),(2,'contado');
/*!40000 ALTER TABLE `tblmetodos_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpropietarios`
--

DROP TABLE IF EXISTS `tblpropietarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpropietarios` (
  `cedula` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_pago` int NOT NULL,
  PRIMARY KEY (`cedula`),
  KEY `fk_tipo_pago` (`tipo_pago`),
  CONSTRAINT `fk_tipo_pago` FOREIGN KEY (`tipo_pago`) REFERENCES `tblmetodos_pago` (`tipo_pago`),
  CONSTRAINT `tblpropietarios_ibfk_1` FOREIGN KEY (`tipo_pago`) REFERENCES `tblmetodos_pago` (`tipo_pago`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpropietarios`
--

LOCK TABLES `tblpropietarios` WRITE;
/*!40000 ALTER TABLE `tblpropietarios` DISABLE KEYS */;
INSERT INTO `tblpropietarios` VALUES ('11151','Pedro',1),('2626','Mario',2),('3131313','Marzo',1),('3322','raul',1),('4332','mkmk',2),('6474','Carlos',1),('6543','Pedro',1),('656565','hugo',2),('8888','mmm',1),('juan','juan',2);
/*!40000 ALTER TABLE `tblpropietarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-17 15:08:58
