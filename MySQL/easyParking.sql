-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: easyparking
-- ------------------------------------------------------
-- Server version	5.7.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria_vehiculo`
--

DROP TABLE IF EXISTS `categoria_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_vehiculo` (
  `codigo_cat` varchar(30) NOT NULL,
  `valor_cat` int(11) NOT NULL,
  PRIMARY KEY (`codigo_cat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_vehiculo`
--

LOCK TABLES `categoria_vehiculo` WRITE;
/*!40000 ALTER TABLE `categoria_vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradas`
--

DROP TABLE IF EXISTS `entradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entradas` (
  `ide_ent` varchar(30) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `fecha_ent` datetime NOT NULL,
  `hora_ent` time NOT NULL,
  `codigo_cat` varchar(30) DEFAULT NULL,
  `nit` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ide_ent`),
  KEY `entradas_codigo_cat_fk` (`codigo_cat`),
  KEY `entradas_nit_fk` (`nit`),
  CONSTRAINT `entradas_codigo_cat_fk` FOREIGN KEY (`codigo_cat`) REFERENCES `categoria_vehiculo` (`codigo_cat`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `entradas_nit_fk` FOREIGN KEY (`nit`) REFERENCES `parqueadero` (`nit`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradas`
--

LOCK TABLES `entradas` WRITE;
/*!40000 ALTER TABLE `entradas` DISABLE KEYS */;
/*!40000 ALTER TABLE `entradas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueadero`
--

DROP TABLE IF EXISTS `parqueadero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parqueadero` (
  `nit` varchar(15) NOT NULL,
  `razon_social` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `plaza_carro` int(11) NOT NULL,
  `plaza_moto` int(11) NOT NULL,
  `codigo_usu` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`nit`),
  KEY `parqueadero_codigo_usu_fk` (`codigo_usu`),
  CONSTRAINT `parqueadero_codigo_usu_fk` FOREIGN KEY (`codigo_usu`) REFERENCES `usuario` (`codigo_usu`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueadero`
--

LOCK TABLES `parqueadero` WRITE;
/*!40000 ALTER TABLE `parqueadero` DISABLE KEYS */;
/*!40000 ALTER TABLE `parqueadero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salidas`
--

DROP TABLE IF EXISTS `salidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salidas` (
  `ide_sal` varchar(30) NOT NULL,
  `fecha_sal` datetime NOT NULL,
  `hora_sal` time NOT NULL,
  `valor_pagar` int(11) NOT NULL,
  `nit` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ide_sal`),
  KEY `salidas_nit_fk` (`nit`),
  CONSTRAINT `salidas_nit_fk` FOREIGN KEY (`nit`) REFERENCES `parqueadero` (`nit`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidas`
--

LOCK TABLES `salidas` WRITE;
/*!40000 ALTER TABLE `salidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `salidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codigo_usu` varchar(15) NOT NULL,
  `nombre_usu` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-29 10:38:54
