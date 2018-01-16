-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: smart-cacao
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `ACTIVIDAD`
--

DROP TABLE IF EXISTS `ACTIVIDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACTIVIDAD` (
  `COD_ACTIVIDAD` int(11) NOT NULL AUTO_INCREMENT,
  `COD_TIPO_ACTIVIDAD` varchar(10) NOT NULL,
  `COD_COSECHA` int(11) DEFAULT NULL,
  `NOTA` varchar(512) DEFAULT NULL,
  `FECHA_ULTIMA_EJECUCION` date NOT NULL,
  `ESTADO` varchar(3) NOT NULL,
  PRIMARY KEY (`COD_ACTIVIDAD`,`COD_TIPO_ACTIVIDAD`),
  KEY `FK_REFERENCE_13` (`COD_COSECHA`),
  KEY `FK_REFERENCE_4` (`COD_TIPO_ACTIVIDAD`),
  CONSTRAINT `FK_REFERENCE_13` FOREIGN KEY (`COD_COSECHA`) REFERENCES `COSECHA` (`COD_COSECHA`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`COD_TIPO_ACTIVIDAD`) REFERENCES `TIPO_ACTIVIDAD` (`COD_TIPO_ACTIVIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIVIDAD`
--

LOCK TABLES `ACTIVIDAD` WRITE;
/*!40000 ALTER TABLE `ACTIVIDAD` DISABLE KEYS */;
INSERT INTO `ACTIVIDAD` VALUES (1,'RIE',1,'Plantacion: 1, Terreno: PRO','2018-01-20','NRE'),(4,'RIE',5,'Plantacion: 5, Terreno: NUR','2018-01-16','NRE'),(5,'CAM',5,'Plantacion: 5, Terreno: NUR','2018-08-17','NRE'),(9,'COS',7,'Plantacion: 7, Terreno: PRO','2018-11-16','NRE'),(10,'DES',7,'Plantacion: 7, Terreno: PRO','2018-05-16','NRE'),(11,'RIE',7,'Plantacion: 7, Terreno: PRO','2018-01-16','NRE');
/*!40000 ALTER TABLE `ACTIVIDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ALARMA`
--

DROP TABLE IF EXISTS `ALARMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALARMA` (
  `COD_ALARMA` int(11) NOT NULL AUTO_INCREMENT,
  `COD_ACTIVIDAD` int(11) DEFAULT NULL,
  `COD_TIPO_ACTIVIDAD` varchar(10) DEFAULT NULL,
  `DESCRIPCION` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`COD_ALARMA`),
  KEY `FK_REFERENCE_15` (`COD_ACTIVIDAD`,`COD_TIPO_ACTIVIDAD`),
  CONSTRAINT `FK_REFERENCE_15` FOREIGN KEY (`COD_ACTIVIDAD`, `COD_TIPO_ACTIVIDAD`) REFERENCES `ACTIVIDAD` (`COD_ACTIVIDAD`, `COD_TIPO_ACTIVIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALARMA`
--

LOCK TABLES `ALARMA` WRITE;
/*!40000 ALTER TABLE `ALARMA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ALARMA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COSECHA`
--

DROP TABLE IF EXISTS `COSECHA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COSECHA` (
  `COD_COSECHA` int(11) NOT NULL AUTO_INCREMENT,
  `COD_TERRENO` int(11) NOT NULL,
  `COD_TIPO_TERRENO` varchar(10) NOT NULL,
  `FECHA_PLANTACION` date NOT NULL,
  PRIMARY KEY (`COD_COSECHA`),
  KEY `FK_REFERENCE_14` (`COD_TERRENO`,`COD_TIPO_TERRENO`),
  CONSTRAINT `FK_REFERENCE_14` FOREIGN KEY (`COD_TERRENO`, `COD_TIPO_TERRENO`) REFERENCES `TERRENO` (`COD_TERRENO`, `COD_TIPO_TERRENO`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COSECHA`
--

LOCK TABLES `COSECHA` WRITE;
/*!40000 ALTER TABLE `COSECHA` DISABLE KEYS */;
INSERT INTO `COSECHA` VALUES (1,2,'PRO','2018-01-15'),(5,3,'NUR','2018-01-16'),(7,2,'PRO','2018-01-15');
/*!40000 ALTER TABLE `COSECHA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTACION`
--

DROP TABLE IF EXISTS `ESTACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTACION` (
  `COD_ESTACION` varchar(10) NOT NULL,
  `COD_MES` int(11) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `DESCRIPCION` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`COD_ESTACION`,`COD_MES`),
  KEY `FK_REFERENCE_9` (`COD_MES`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`COD_MES`) REFERENCES `MES` (`COD_MES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTACION`
--

LOCK TABLES `ESTACION` WRITE;
/*!40000 ALTER TABLE `ESTACION` DISABLE KEYS */;
INSERT INTO `ESTACION` VALUES ('Inve',12,'Invierno','Invierno'),('Vera',2,'Verano','Verano');
/*!40000 ALTER TABLE `ESTACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTADISTICA`
--

DROP TABLE IF EXISTS `ESTADISTICA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTADISTICA` (
  `COD_ESTADISTICA` int(11) NOT NULL AUTO_INCREMENT,
  `COD_COSECHA` int(11) DEFAULT NULL,
  `FECHA_ULTIMA_COSECHA` date NOT NULL,
  `NUMERO_ARBOLES` decimal(5,0) NOT NULL,
  `TOTAL_KILOS` decimal(8,2) NOT NULL,
  PRIMARY KEY (`COD_ESTADISTICA`),
  KEY `FK_REFERENCE_3` (`COD_COSECHA`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`COD_COSECHA`) REFERENCES `COSECHA` (`COD_COSECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTADISTICA`
--

LOCK TABLES `ESTADISTICA` WRITE;
/*!40000 ALTER TABLE `ESTADISTICA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ESTADISTICA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HISTORIAL_ESTACION`
--

DROP TABLE IF EXISTS `HISTORIAL_ESTACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HISTORIAL_ESTACION` (
  `COD_HISTORIAL_ESTACION` int(11) NOT NULL AUTO_INCREMENT,
  `COD_ESTACION` varchar(10) DEFAULT NULL,
  `COD_MES` int(11) DEFAULT NULL,
  `ANIO` date NOT NULL,
  `FECHA_INICIO` date NOT NULL,
  `FECHA_FINALIZACION` date NOT NULL,
  `NOTA` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`COD_HISTORIAL_ESTACION`),
  KEY `FK_REFERENCE_10` (`COD_ESTACION`,`COD_MES`),
  CONSTRAINT `FK_REFERENCE_10` FOREIGN KEY (`COD_ESTACION`, `COD_MES`) REFERENCES `ESTACION` (`COD_ESTACION`, `COD_MES`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HISTORIAL_ESTACION`
--

LOCK TABLES `HISTORIAL_ESTACION` WRITE;
/*!40000 ALTER TABLE `HISTORIAL_ESTACION` DISABLE KEYS */;
INSERT INTO `HISTORIAL_ESTACION` VALUES (1,'Vera',NULL,'2017-01-01','2017-02-02','2017-06-08','Duracion de 4 meses'),(2,'Inve',NULL,'2017-01-01','2017-12-04','2018-04-04','Duracion de 4 meses');
/*!40000 ALTER TABLE `HISTORIAL_ESTACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MES`
--

DROP TABLE IF EXISTS `MES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MES` (
  `COD_MES` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(100) NOT NULL,
  PRIMARY KEY (`COD_MES`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MES`
--

LOCK TABLES `MES` WRITE;
/*!40000 ALTER TABLE `MES` DISABLE KEYS */;
INSERT INTO `MES` VALUES (1,'Enero'),(2,'Febrero'),(3,'Marzo'),(4,'Abril'),(5,'Mayo'),(6,'Junio'),(7,'Julio'),(8,'Agosto'),(9,'Septiembre'),(10,'Octubre'),(11,'Noviembre'),(12,'Diciembre');
/*!40000 ALTER TABLE `MES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REGION`
--

DROP TABLE IF EXISTS `REGION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REGION` (
  `COD_REGION` varchar(10) NOT NULL,
  `COD_ESTACION` varchar(10) DEFAULT NULL,
  `COD_MES` int(11) DEFAULT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  PRIMARY KEY (`COD_REGION`),
  KEY `FK_REFERENCE_12` (`COD_ESTACION`,`COD_MES`),
  CONSTRAINT `FK_REFERENCE_12` FOREIGN KEY (`COD_ESTACION`, `COD_MES`) REFERENCES `ESTACION` (`COD_ESTACION`, `COD_MES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REGION`
--

LOCK TABLES `REGION` WRITE;
/*!40000 ALTER TABLE `REGION` DISABLE KEYS */;
INSERT INTO `REGION` VALUES ('And','Inve',12,'Andes'),('Cos','Vera',2,'Costa');
/*!40000 ALTER TABLE `REGION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TERRENO`
--

DROP TABLE IF EXISTS `TERRENO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TERRENO` (
  `COD_TERRENO` int(11) NOT NULL AUTO_INCREMENT,
  `COD_TIPO_TERRENO` varchar(10) NOT NULL,
  `COD_REGION` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(512) DEFAULT NULL,
  `ANCHO` decimal(8,2) NOT NULL,
  `LARGO` decimal(8,2) NOT NULL,
  PRIMARY KEY (`COD_TERRENO`,`COD_TIPO_TERRENO`),
  KEY `FK_REFERENCE_5` (`COD_TIPO_TERRENO`),
  KEY `FK_REFERENCE_7` (`COD_REGION`),
  CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`COD_TIPO_TERRENO`) REFERENCES `TIPO_TERRENO` (`COD_TIPO_TERRENO`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`COD_REGION`) REFERENCES `REGION` (`COD_REGION`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TERRENO`
--

LOCK TABLES `TERRENO` WRITE;
/*!40000 ALTER TABLE `TERRENO` DISABLE KEYS */;
INSERT INTO `TERRENO` VALUES (2,'PRO','Cos','Produccion',220.00,123.00),(3,'NUR','Cos','Nursery',300.00,300.00);
/*!40000 ALTER TABLE `TERRENO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_ACTIVIDAD`
--

DROP TABLE IF EXISTS `TIPO_ACTIVIDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_ACTIVIDAD` (
  `COD_TIPO_ACTIVIDAD` varchar(10) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `DESCRIPCION` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`COD_TIPO_ACTIVIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_ACTIVIDAD`
--

LOCK TABLES `TIPO_ACTIVIDAD` WRITE;
/*!40000 ALTER TABLE `TIPO_ACTIVIDAD` DISABLE KEYS */;
INSERT INTO `TIPO_ACTIVIDAD` VALUES ('CAM','Cambio Terreno','Cambio de terreno de nursery a produccion'),('COS','Cosecha','Proceso de cosecha de cacao'),('DES','Deshierbar','Proceso de deshierbado del terreno'),('RIE','Riego','Proceso de regado del terreno');
/*!40000 ALTER TABLE `TIPO_ACTIVIDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_TERRENO`
--

DROP TABLE IF EXISTS `TIPO_TERRENO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_TERRENO` (
  `COD_TIPO_TERRENO` varchar(10) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `DESCRIPCION` varchar(512) NOT NULL,
  PRIMARY KEY (`COD_TIPO_TERRENO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_TERRENO`
--

LOCK TABLES `TIPO_TERRENO` WRITE;
/*!40000 ALTER TABLE `TIPO_TERRENO` DISABLE KEYS */;
INSERT INTO `TIPO_TERRENO` VALUES ('NUR','Nursery','Terreno de plantación inicial para los árboles'),('PRO','Producción','Terreno de producción para los árboles');
/*!40000 ALTER TABLE `TIPO_TERRENO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_USUARIO`
--

DROP TABLE IF EXISTS `TIPO_USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_USUARIO` (
  `COD_TIPO_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(3) NOT NULL,
  `DESCRIPCION` varchar(512) NOT NULL,
  PRIMARY KEY (`COD_TIPO_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_USUARIO`
--

LOCK TABLES `TIPO_USUARIO` WRITE;
/*!40000 ALTER TABLE `TIPO_USUARIO` DISABLE KEYS */;
INSERT INTO `TIPO_USUARIO` VALUES (1,'ADM','Administrador'),(2,'OPE','Operacional');
/*!40000 ALTER TABLE `TIPO_USUARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USUARIO` (
  `COD_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `COD_TIPO_USUARIO` int(11) DEFAULT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `APELLIDO` varchar(100) NOT NULL,
  `PASSWORD` varchar(512) NOT NULL,
  `TELEFONO` varchar(14) NOT NULL,
  `EMAIL` varchar(256) NOT NULL,
  PRIMARY KEY (`COD_USUARIO`),
  KEY `FK_REFERENCE_11` (`COD_TIPO_USUARIO`),
  CONSTRAINT `FK_REFERENCE_11` FOREIGN KEY (`COD_TIPO_USUARIO`) REFERENCES `TIPO_USUARIO` (`COD_TIPO_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES (1,1,'Joel','Rivera','joelram5635726','+593998256122','joelram1@hotmail.com'),(2,2,'Alejandro','Villamarin','avm112358','+593997103831','avm@email.com'),(3,2,'Sylvia','Moncayo','sdfg','+593997193831','slma17@email.com');
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-16 18:12:51
