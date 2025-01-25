-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: pos_of_roxeleye
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `hotline` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'no','0'),(2,'abc','0112569912');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `nic` varchar(14) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `points` int DEFAULT NULL,
  `due_payments` double DEFAULT NULL,
  `registered_date` datetime DEFAULT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_customer_status1_idx` (`status_id`),
  CONSTRAINT `fk_customer_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('0','','',0,0,'2024-05-26 12:58:50',1),('200408213962','R.M Rashan','0766923220',23,0,'2024-05-26 12:58:50',0),('200408213967','dfgb','0766923225',0,0,'2025-01-22 23:02:53',1),('2004082313965','SDV','0766923224',0,0,'2025-01-22 22:54:19',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empliyee_id` varchar(20) NOT NULL,
  `e_fname` varchar(45) DEFAULT NULL,
  `e_lname` varchar(45) DEFAULT NULL,
  `e_nic` varchar(14) DEFAULT NULL,
  `e_mobile` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender_id` int NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status_id` int NOT NULL,
  `employee_type_id` int NOT NULL,
  PRIMARY KEY (`empliyee_id`),
  KEY `fk_employee_employee_type1_idx` (`employee_type_id`),
  KEY `fk_employee_gender1_idx` (`gender_id`),
  KEY `fk_employee_status1_idx` (`status_id`),
  CONSTRAINT `fk_employee_employee_type1` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`),
  CONSTRAINT `fk_employee_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_employee_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('120',NULL,NULL,NULL,NULL,NULL,1,'123456',1,1),('E-121','abc','def','20040','0766923220','11232',1,'123',1,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_type`
--

DROP TABLE IF EXISTS `employee_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_type`
--

LOCK TABLES `employee_type` WRITE;
/*!40000 ALTER TABLE `employee_type` DISABLE KEYS */;
INSERT INTO `employee_type` VALUES (1,'Admin'),(2,'Cashier');
/*!40000 ALTER TABLE `employee_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `g_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Male'),(2,'Female');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn`
--

DROP TABLE IF EXISTS `grn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn` (
  `grn_id` varchar(25) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `supplier_id` int DEFAULT '0',
  PRIMARY KEY (`grn_id`),
  KEY `fk_grn_supplier1_idx` (`supplier_id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn`
--

LOCK TABLES `grn` WRITE;
/*!40000 ALTER TABLE `grn` DISABLE KEYS */;
INSERT INTO `grn` VALUES ('GRN-20241114222955','2024-11-14 22:29:55',0,1000,1),('GRN-20250116203626','2025-01-16 20:36:26',0,800,1),('GRN-20250117145159','2025-01-17 14:51:59',0,100,1);
/*!40000 ALTER TABLE `grn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn_items`
--

DROP TABLE IF EXISTS `grn_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn_items` (
  `grn_item_id` int NOT NULL AUTO_INCREMENT,
  `qty` int DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  `stock_barcode` bigint NOT NULL,
  `grn_grn_id` varchar(25) NOT NULL,
  PRIMARY KEY (`grn_item_id`),
  KEY `fk_grn_items_grn1_idx` (`grn_grn_id`),
  KEY `fk_grn_items_stock1_idx` (`stock_barcode`),
  CONSTRAINT `fk_grn_items_grn1` FOREIGN KEY (`grn_grn_id`) REFERENCES `grn` (`grn_id`),
  CONSTRAINT `fk_grn_items_stock1` FOREIGN KEY (`stock_barcode`) REFERENCES `stock` (`barcode`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn_items`
--

LOCK TABLES `grn_items` WRITE;
/*!40000 ALTER TABLE `grn_items` DISABLE KEYS */;
INSERT INTO `grn_items` VALUES (10,20,100,1111,'GRN-20241114222955'),(11,10,80,123,'GRN-20250116203626'),(12,10,10,1234,'GRN-20250117145159');
/*!40000 ALTER TABLE `grn_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `inv_id` varchar(20) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `paid_amount` varchar(10) DEFAULT NULL,
  `total` varchar(10) DEFAULT NULL,
  `taken_point` int DEFAULT NULL,
  `customer_nic` varchar(14) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `paymentMethod_id` int NOT NULL,
  PRIMARY KEY (`inv_id`),
  KEY `fk_invoice_customer1_idx` (`customer_nic`),
  KEY `fk_invoice_paymentMethod1_idx` (`paymentMethod_id`),
  CONSTRAINT `fk_invoice_customer1` FOREIGN KEY (`customer_nic`) REFERENCES `customer` (`nic`),
  CONSTRAINT `fk_invoice_paymentMethod1` FOREIGN KEY (`paymentMethod_id`) REFERENCES `paymentmethod` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES ('INV-20241114231459','2024-11-14 23:14:59','1000','1000',0,'0',1),('INV-20250117200827','2025-01-17 20:08:27','10000','10000',0,'0',1),('INV-20250117201756','2025-01-17 20:17:56','1000','1000',0,'0',1),('INV-20250118131817','2025-01-18 13:18:17','1000','1000',0,'0',1),('INV-20250118132349','2025-01-18 13:23:49','1000','1000',0,'0',1),('INV-20250118211703','2025-01-18 21:17:03','1000','1000',0,'0',1),('INV-20250118212111','2025-01-18 21:21:11','1000','1000',0,'0',1),('INV-20250118213852','2025-01-18 21:38:52','1000','1000',0,'0',1),('INV-20250118215138','2025-01-18 21:51:38','1000','1000',0,'0',1),('INV-20250118215410','2025-01-18 21:54:10','1000','1000',0,'0',1),('INV-20250118215539','2025-01-18 21:55:39','1000','1000',0,'0',1),('INV-20250118220037','2025-01-18 22:00:37','1000','1000',0,'0',1),('INV-20250118220146','2025-01-18 22:01:46','1000','1000',0,'0',1),('INV-20250118220322','2025-01-18 22:03:22','1000','1000',0,'0',1),('INV-20250118220444','2025-01-18 22:04:44','1000','1000',0,'0',1),('INV-20250118220605','2025-01-18 22:06:05','1000','1000',0,'0',1),('INV-20250118220637','2025-01-18 22:06:37','1000','1000',0,'0',1),('INV-20250118221058','2025-01-18 22:10:58','1000','1000',0,'0',1),('INV-20250121201103','2025-01-21 20:11:03','1000','1000',0,'0',1),('INV-20250122220243','2025-01-22 22:02:43','1000','1000',0,'0',1),('INV-20250122222150','2025-01-22 22:21:50','5000','5000',0,'0',1),('INV-20250122222219','2025-01-22 22:22:19','2000','2000',0,'0',1),('INV-20250122233004','2025-01-22 23:30:04','1000','1000',0,'0',1),('INV-20250122233132','2025-01-22 23:31:32','1000','1000',0,'0',1),('INV-20250123015217','2025-01-23 01:52:17','10000','10000',0,'0',1);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_items`
--

DROP TABLE IF EXISTS `invoice_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` varchar(45) DEFAULT NULL,
  `stock_barcode` bigint NOT NULL,
  `invoice_inv_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_items_invoice1_idx` (`invoice_inv_id`),
  KEY `fk_invoice_items_stock1_idx` (`stock_barcode`),
  CONSTRAINT `fk_invoice_items_invoice1` FOREIGN KEY (`invoice_inv_id`) REFERENCES `invoice` (`inv_id`),
  CONSTRAINT `fk_invoice_items_stock1` FOREIGN KEY (`stock_barcode`) REFERENCES `stock` (`barcode`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_items`
--

LOCK TABLES `invoice_items` WRITE;
/*!40000 ALTER TABLE `invoice_items` DISABLE KEYS */;
INSERT INTO `invoice_items` VALUES (3,'10',1111,'INV-20241114231459'),(4,'10',123,'INV-20250117200827'),(5,'1',123,'INV-20250117201756'),(6,'1',123,'INV-20250118131817'),(7,'1',123,'INV-20250118132349'),(8,'1',123,'INV-20250118211703'),(9,'1',123,'INV-20250118212111'),(10,'1',123,'INV-20250118213852'),(11,'1',123,'INV-20250118215138'),(12,'1',123,'INV-20250118215410'),(13,'1',123,'INV-20250118215539'),(14,'1',123,'INV-20250118220037'),(15,'1',123,'INV-20250118220146'),(16,'1',123,'INV-20250118220322'),(17,'1',123,'INV-20250118220444'),(18,'1',123,'INV-20250118220605'),(19,'1',123,'INV-20250118220637'),(20,'1',123,'INV-20250118221058'),(21,'1',123,'INV-20250121201103'),(22,'1',123,'INV-20250122220243'),(23,'5',123,'INV-20250122222150'),(24,'2',123,'INV-20250122222219'),(25,'1',123,'INV-20250122233004'),(26,'1',123,'INV-20250122233132'),(27,'10',1111,'INV-20250123015217');
/*!40000 ALTER TABLE `invoice_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmethod` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mthod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
INSERT INTO `paymentmethod` VALUES (1,'Cash'),(2,'Card');
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (8,'iuhuh'),(9,'oil'),(10,'jj');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_unit`
--

DROP TABLE IF EXISTS `product_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_unit`
--

LOCK TABLES `product_unit` WRITE;
/*!40000 ALTER TABLE `product_unit` DISABLE KEYS */;
INSERT INTO `product_unit` VALUES (4,'1L'),(5,'100g'),(6,'1Kg'),(7,'packet ');
/*!40000 ALTER TABLE `product_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Active'),(2,'Block');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `barcode` bigint NOT NULL,
  `selling_price` int DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `mfg` date DEFAULT NULL,
  `exp` date DEFAULT NULL,
  `product_id` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`barcode`),
  KEY `fk_stock_product1_idx` (`product_id`),
  KEY `fk_stock_status1_idx` (`status_id`),
  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_stock_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (123,100,0,'2025-01-16','2026-01-16',9,1),(1111,100,990,'2024-11-01','2024-11-23',8,1),(1234,20,0,'2025-01-02','2025-01-31',10,1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_company1_idx` (`company_id`),
  CONSTRAINT `fk_supplier_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'no','0',1),(2,'abc','0766923220',2);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-23  2:15:57
