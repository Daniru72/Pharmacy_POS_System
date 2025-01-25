-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for pos_of_roxeleye
CREATE DATABASE IF NOT EXISTS `pos_of_roxeleye` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pos_of_roxeleye`;

-- Dumping structure for table pos_of_roxeleye.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `hotline` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.company: ~5 rows (approximately)
REPLACE INTO `company` (`id`, `company_name`, `hotline`) VALUES
	(1, 'PharmaCorp', '0115580404'),
	(2, 'MediHealth', '0112569912'),
	(3, 'ApexMed', '0112230504'),
	(4, 'TrustedMed', '0115560704'),
	(5, 'LifeLine Industries', '0113340503');

-- Dumping structure for table pos_of_roxeleye.customer
CREATE TABLE IF NOT EXISTS `customer` (
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

-- Dumping data for table pos_of_roxeleye.customer: ~3 rows (approximately)
REPLACE INTO `customer` (`nic`, `username`, `mobile`, `points`, `due_payments`, `registered_date`, `status_id`) VALUES
	('0', 'Amara', '0719463050', 0, 0, '2024-05-26 12:58:50', 1),
	('200408213962', 'Daniru', '0766923220', 38, 1600, '2024-05-26 12:58:50', 0),
	('200539405557', 'Kumara', '0710537080', 0, 0, '2025-01-22 23:04:36', 1);

-- Dumping structure for table pos_of_roxeleye.employee
CREATE TABLE IF NOT EXISTS `employee` (
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

-- Dumping data for table pos_of_roxeleye.employee: ~3 rows (approximately)
REPLACE INTO `employee` (`empliyee_id`, `e_fname`, `e_lname`, `e_nic`, `e_mobile`, `address`, `gender_id`, `password`, `status_id`, `employee_type_id`) VALUES
	('120', 'Daniru', 'Dahamneth', '200229202225', '0710632050', 'Balasuriya Mavatha, Kandana', 1, '123456', 1, 1),
	('456', 'Saman', 'Edirimuni', '200226273336', '0774155687', 'Kanaththa Road, Kandana', 1, 'Saman123', 1, 2),
	('E-457', 'Sunil', 'Perera', '200239406664', '0775188621', '66/B, Kanaththa Road, Kandana', 2, 'Sunil123', 1, 2);

-- Dumping structure for table pos_of_roxeleye.employee_type
CREATE TABLE IF NOT EXISTS `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.employee_type: ~2 rows (approximately)
REPLACE INTO `employee_type` (`id`, `e_type`) VALUES
	(1, 'Admin'),
	(2, 'Cashier');

-- Dumping structure for table pos_of_roxeleye.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `g_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.gender: ~2 rows (approximately)
REPLACE INTO `gender` (`id`, `g_type`) VALUES
	(1, 'Male'),
	(2, 'Female');

-- Dumping structure for table pos_of_roxeleye.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `grn_id` varchar(25) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `supplier_id` int DEFAULT '0',
  PRIMARY KEY (`grn_id`),
  KEY `fk_grn_supplier1_idx` (`supplier_id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.grn: ~8 rows (approximately)
REPLACE INTO `grn` (`grn_id`, `date_time`, `paid_amount`, `balance`, `supplier_id`) VALUES
	('GRN-20241114222955', '2024-11-14 22:29:55', 0, 1000, 1),
	('GRN-20250117220711', '2025-01-17 22:07:11', 0, 2000, 2),
	('GRN-20250117231210', '2025-01-17 23:12:10', 0, 2000, 2),
	('GRN-20250122222748', '2025-01-22 22:27:48', 0, 23700, 3),
	('GRN-20250122223132', '2025-01-22 22:31:32', 0, 17000, 4),
	('GRN-20250122223749', '2025-01-22 22:37:49', 0, 97500, 5),
	('GRN-20250122225638', '2025-01-22 22:56:38', 0, 40000, 5),
	('GRN-20250122230249', '2025-01-22 23:02:49', 0, 30000, 4);

-- Dumping structure for table pos_of_roxeleye.grn_items
CREATE TABLE IF NOT EXISTS `grn_items` (
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.grn_items: ~14 rows (approximately)
REPLACE INTO `grn_items` (`grn_item_id`, `qty`, `buying_price`, `stock_barcode`, `grn_grn_id`) VALUES
	(10, 20, 100, 1111, 'GRN-20241114222955'),
	(11, 10, 200, 12345, 'GRN-20250117220711'),
	(12, 10, 200, 1234, 'GRN-20250117231210'),
	(13, 150, 70, 8901, 'GRN-20250122222748'),
	(14, 80, 90, 89012, 'GRN-20250122222748'),
	(15, 40, 150, 890123, 'GRN-20250122222748'),
	(16, 100, 50, 89018, 'GRN-20250122223132'),
	(17, 60, 200, 89016, 'GRN-20250122223132'),
	(18, 200, 150, 89019, 'GRN-20250122223749'),
	(19, 300, 45, 890127, 'GRN-20250122223749'),
	(20, 300, 180, 890125, 'GRN-20250122223749'),
	(21, 50, 800, 89017, 'GRN-20250122225638'),
	(22, 100, 140, 12378, 'GRN-20250122230249'),
	(23, 20, 800, 123789, 'GRN-20250122230249');

-- Dumping structure for table pos_of_roxeleye.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
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

-- Dumping data for table pos_of_roxeleye.invoice: ~9 rows (approximately)
REPLACE INTO `invoice` (`inv_id`, `date_time`, `paid_amount`, `total`, `taken_point`, `customer_nic`, `paymentMethod_id`) VALUES
	('INV-20241114231459', '2024-11-14 23:14:59', '1000', '1000', 0, '0', 1),
	('INV-20250118202421', '2025-01-18 20:24:21', '0', '500', 0, '200408213962', 1),
	('INV-20250118215422', '2025-01-18 21:54:22', '0', '500', 0, '200408213962', 1),
	('INV-20250118215957', '2025-01-18 21:59:57', '0', '500', 0, '200408213962', 1),
	('INV-20250118221503', '2025-01-18 22:15:03', '500', '500', 0, '0', 1),
	('INV-20250118221610', '2025-01-18 22:16:10', '500', '500', 0, '0', 1),
	('INV-20250118222205', '2025-01-18 22:22:05', '500', '500', 0, '0', 1),
	('INV-20250118222911', '2025-01-18 22:29:11', '500', '500', 0, '0', 1),
	('INV-20250122220905', '2025-01-22 22:09:05', '500', '500', 0, '200408213962', 1);

-- Dumping structure for table pos_of_roxeleye.invoice_items
CREATE TABLE IF NOT EXISTS `invoice_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` varchar(45) DEFAULT NULL,
  `stock_barcode` bigint NOT NULL,
  `invoice_inv_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_items_invoice1_idx` (`invoice_inv_id`),
  KEY `fk_invoice_items_stock1_idx` (`stock_barcode`),
  CONSTRAINT `fk_invoice_items_invoice1` FOREIGN KEY (`invoice_inv_id`) REFERENCES `invoice` (`inv_id`),
  CONSTRAINT `fk_invoice_items_stock1` FOREIGN KEY (`stock_barcode`) REFERENCES `stock` (`barcode`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.invoice_items: ~9 rows (approximately)
REPLACE INTO `invoice_items` (`id`, `qty`, `stock_barcode`, `invoice_inv_id`) VALUES
	(3, '10', 1111, 'INV-20241114231459'),
	(4, '2', 1234, 'INV-20250118202421'),
	(5, '2', 1234, 'INV-20250118215422'),
	(6, '2', 1234, 'INV-20250118215957'),
	(7, '2', 1234, 'INV-20250118221503'),
	(8, '2', 1234, 'INV-20250118221610'),
	(9, '2', 1234, 'INV-20250118222205'),
	(10, '2', 1234, 'INV-20250118222911'),
	(11, '2', 1234, 'INV-20250122220905');

-- Dumping structure for table pos_of_roxeleye.paymentmethod
CREATE TABLE IF NOT EXISTS `paymentmethod` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mthod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.paymentmethod: ~2 rows (approximately)
REPLACE INTO `paymentmethod` (`id`, `mthod`) VALUES
	(1, 'Cash'),
	(2, 'Card');

-- Dumping structure for table pos_of_roxeleye.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(50) DEFAULT NULL,
  `product_unit_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prodcut_product_unit1_idx` (`product_unit_id`),
  CONSTRAINT `fk_prodcut_product_unit1` FOREIGN KEY (`product_unit_id`) REFERENCES `product_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.product: ~13 rows (approximately)
REPLACE INTO `product` (`id`, `p_name`, `product_unit_id`) VALUES
	(8, 'Surgical Mask (50-pack)', NULL),
	(9, 'Baby Diapers', NULL),
	(10, 'Paracetamol 500mg', NULL),
	(11, 'Cough Syrup 100ml', NULL),
	(12, 'Vitamin C Tablets', NULL),
	(13, 'Antacid Tablets', NULL),
	(14, 'Multivitamin Syrup 200ml', NULL),
	(15, 'Pregnancy Test Kit', NULL),
	(16, 'Amoxicillin Capsules', NULL),
	(17, 'Hand Sanitizer 500ml', NULL),
	(18, 'Insulin Injection Pen', NULL),
	(19, 'Vitamin D Drops 15ml', NULL),
	(20, 'Blood Pressure Monitor', NULL);

-- Dumping structure for table pos_of_roxeleye.product_unit
CREATE TABLE IF NOT EXISTS `product_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.product_unit: ~2 rows (approximately)
REPLACE INTO `product_unit` (`id`, `unit`) VALUES
	(4, '1'),
	(5, '2');

-- Dumping structure for table pos_of_roxeleye.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.status: ~2 rows (approximately)
REPLACE INTO `status` (`id`, `status`) VALUES
	(1, 'Active'),
	(2, 'Block');

-- Dumping structure for table pos_of_roxeleye.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `barcode` bigint NOT NULL,
  `selling_price` double DEFAULT NULL,
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

-- Dumping data for table pos_of_roxeleye.stock: ~14 rows (approximately)
REPLACE INTO `stock` (`barcode`, `selling_price`, `qty`, `mfg`, `exp`, `product_id`, `status_id`) VALUES
	(1111, 100, 1, '2024-11-01', '2024-11-23', 8, 1),
	(1234, 250, -6, '2025-01-07', '2025-01-31', 9, 1),
	(8901, 100, 150, '2025-01-01', '2025-01-31', 10, 1),
	(12345, 250, 10, '2025-01-14', '2025-01-31', 9, 1),
	(12378, 150, 100, '2025-01-01', '2025-02-24', 19, 1),
	(89012, 100, 80, '2025-01-01', '2025-01-29', 11, 1),
	(89016, 230, 60, '2025-01-01', '2025-01-29', 14, 1),
	(89017, 900, 50, '2024-11-04', '2025-01-31', 18, 1),
	(89018, 55, 100, '2024-12-02', '2025-02-11', 13, 1),
	(89019, 160, 200, '2024-11-04', '2025-04-24', 15, 1),
	(123789, 900, 20, '2024-08-05', '2025-06-27', 20, 1),
	(890123, 200, 40, '2024-12-11', '2025-01-28', 12, 1),
	(890125, 190, 300, '2025-01-01', '2025-03-26', 17, 1),
	(890127, 50, 300, '2025-01-01', '2025-03-28', 16, 1);

-- Dumping structure for table pos_of_roxeleye.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_company1_idx` (`company_id`),
  CONSTRAINT `fk_supplier_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.supplier: ~5 rows (approximately)
REPLACE INTO `supplier` (`id`, `supplier_name`, `mobile`, `company_id`) VALUES
	(1, 'Health Pharma Supplies', '0775188634', 1),
	(2, 'Daniru', '0710632050', 3),
	(3, 'Sunil Perera', '0773166787', 2),
	(4, 'Sithum Lakmal', '0755958945', 4),
	(5, 'Sampath Perera', '0753849678', 5);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
