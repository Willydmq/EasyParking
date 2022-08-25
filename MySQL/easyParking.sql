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

-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `placa_veh` varchar(10) NOT NULL,
  `color_veh` varchar(10) NOT NULL,
  `modelo_veh` varchar(10) NOT NULL,
  `clase_veh` varchar(10) NOT NULL,
  PRIMARY KEY (`placa_veh`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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

-- Dump completed on 2022-08-23 11:22:05
CREATE TABLE servicio (
  num_ser int (4) NOT NULL,
  fec_ser date  NOT NULL,
  Val_ser int (6) not null,
  horaEntrada_ser date not null,
  horaSalida_ser date not null,
  iva_ser int (6) not null,
  pla_veh_ser varchar (8) not null,
  nom_cli_ser varchar (30) not null,
  ape_cli_ser varchar (30) not null,
  constraint servicio_pk primary key (num_ser)
  );
  
  /* datos para insertar en la tabla de servicios */
  
  insert into servicio values (1,"20/08/2022",1000,"06:00","07:00",190,"AAA-123","Carlos","morales sanabria");
  insert into servicio values (2,"21/08/2022",1000,"07:00","08:00",190,"BBB-456","MAaria","rojas estipia");
  insert into servicio values (3,"22/08/2022",1000,"09:00","10:00",190,"CCC-789","rodrigo","perez bejarano");
  insert into servicio values (4,"23/08/2022",1000,"10:00","11:00",190,"DDD-901","Camilo","rojas alvarez");
  insert into servicio values (5,"24/08/2022",1000,"11:00","12:00",190,"EEE-254","laura","martinez gamboa");
  
/*  glosario
num_ser: numero servicio
  fec_ser:fecha servicio
  Val_ser:valor servicio
  iva_se: iva servicior 
  pla_veh_ser: placa vehiculo servicio
  nom_cli_ser: nombre cliente servicio
  ape_cli_ser: apellidos cliente servicio
  horaSalida_ser: hora de salida del servicio
  horaEntrada_ser: hora de entrada del servicio
  */
  


