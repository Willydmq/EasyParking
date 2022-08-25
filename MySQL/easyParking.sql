-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: parking
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni_cli` varchar(15) NOT NULL,
  `nombre_cli` varchar(30) NOT NULL,
  `apellido_cli` varchar(30) NOT NULL,
  `telefono_cli` varchar(20) NOT NULL,
  PRIMARY KEY (`dni_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('1832305','Colette','Nielsen','506-1833'),('5133354','Hu','England','328-6544'),('5354793','Dorothy','Curtis','723-4271'),('938360','Dennis','Sutton','573-6531'),('9396381','Matthew','Livingston','797-3502');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `numero_fac` int NOT NULL AUTO_INCREMENT,
  `fecha_fac` timestamp NOT NULL,
  `valorTotal_fac` double NOT NULL,
  `pago_fac` varchar(20) NOT NULL,
  PRIMARY KEY (`numero_fac`),
  CONSTRAINT `factura_pago_fac_ck` CHECK (((`pago_fac` = _utf8mb4'Efectivo') or (`pago_fac` = _utf8mb4'Debito') or (`pago_fac` = _utf8mb4'Transfer')))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,'2019-05-08 05:00:00',3000,'Efectivo'),(2,'2019-05-18 05:00:00',6000,'Efectivo'),(3,'2019-05-28 05:00:00',9000,'Debito'),(4,'2019-06-08 05:00:00',3500,'Debito'),(5,'2019-06-18 05:00:00',7000,'Transfer');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `num_ser` int NOT NULL,
  `fec_ser` datetime NOT NULL,
  `Val_ser` int NOT NULL,
  `horaEntrada_ser` time NOT NULL,
  `horaSalida_ser` time NOT NULL,
  `iva_ser` int NOT NULL,
  `pla_veh_ser` varchar(8) NOT NULL,
  `nom_cli_ser` varchar(30) NOT NULL,
  `ape_cli_ser` varchar(30) NOT NULL,
  PRIMARY KEY (`num_ser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'2019-05-08 00:00:00',1000,'06:00:00','07:00:00',190,'AAA-123','Carlos','morales sanabria'),(2,'2019-06-08 00:00:00',1000,'07:00:00','08:00:00',190,'BBB-456','MAaria','rojas estipia'),(3,'2019-07-08 00:00:00',1000,'09:00:00','10:00:00',190,'CCC-789','rodrigo','perez bejarano'),(4,'2019-08-08 00:00:00',1000,'10:00:00','11:00:00',190,'DDD-901','Camilo','rojas alvarez'),(5,'2019-09-08 00:00:00',1000,'11:00:00','12:00:00',190,'EEE-254','laura','martinez gamboa');
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `placa_veh` varchar(10) NOT NULL,
  `color_veh` varchar(10) NOT NULL,
  `modelo_veh` varchar(10) NOT NULL,
  `clase_veh` varchar(10) NOT NULL,
  PRIMARY KEY (`placa_veh`),
  CONSTRAINT `vehiculo_clase_veh_ck` CHECK (((`clase_veh` = _utf8mb4'Camion') or (`clase_veh` = _utf8mb4'Campero') or (`clase_veh` = _utf8mb4'Automovil') or (`clase_veh` = _utf8mb4'Motocicleta')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES ('AQR43A','rojo','ug','Camion'),('FRN61','blanco','ninguno','Camion'),('SMM78B','verde','esperanza','Automovil'),('ttr89b','amarillo','allegro','Automovil'),('vvg12r','negro','bronco','Campero');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-25 14:05:21
