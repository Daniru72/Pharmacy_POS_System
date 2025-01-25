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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.company: ~0 rows (approximately)
REPLACE INTO `company` (`id`, `company_name`, `hotline`) VALUES
	(1, 'no', '0'),
	(2, 'abc', '0112569912');

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

-- Dumping data for table pos_of_roxeleye.customer: ~1 rows (approximately)
REPLACE INTO `customer` (`nic`, `username`, `mobile`, `points`, `due_payments`, `registered_date`, `status_id`) VALUES
	('0', '', '', 0, 0, '2024-05-26 12:58:50', 1),
	('200408213962', 'R.M Rashan', '0766923220', 23, 200, '2024-05-26 12:58:50', 0);

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

-- Dumping data for table pos_of_roxeleye.employee: ~0 rows (approximately)
REPLACE INTO `employee` (`empliyee_id`, `e_fname`, `e_lname`, `e_nic`, `e_mobile`, `address`, `gender_id`, `password`, `status_id`, `employee_type_id`) VALUES
	('123', NULL, NULL, NULL, NULL, NULL, 1, '123456', 1, 1);

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

-- Dumping data for table pos_of_roxeleye.grn: ~2 rows (approximately)
REPLACE INTO `grn` (`grn_id`, `date_time`, `paid_amount`, `balance`, `supplier_id`) VALUES
	('GRN-20241114222955', '2024-11-14 22:29:55', 0, 1000, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.grn_items: ~0 rows (approximately)
REPLACE INTO `grn_items` (`grn_item_id`, `qty`, `buying_price`, `stock_barcode`, `grn_grn_id`) VALUES
	(10, 20, 100, 1111, 'GRN-20241114222955');

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

-- Dumping data for table pos_of_roxeleye.invoice: ~0 rows (approximately)
REPLACE INTO `invoice` (`inv_id`, `date_time`, `paid_amount`, `total`, `taken_point`, `customer_nic`, `paymentMethod_id`) VALUES
	('INV-20241114231459', '2024-11-14 23:14:59', '1000', '1000', 0, '0', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.invoice_items: ~0 rows (approximately)
REPLACE INTO `invoice_items` (`id`, `qty`, `stock_barcode`, `invoice_inv_id`) VALUES
	(3, '10', 1111, 'INV-20241114231459');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.product: ~0 rows (approximately)
REPLACE INTO `product` (`id`, `p_name`, `product_unit_id`) VALUES
	(8, 'iuhuh', NULL);

-- Dumping structure for table pos_of_roxeleye.product_unit
CREATE TABLE IF NOT EXISTS `product_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.product_unit: ~1 rows (approximately)

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

-- Dumping data for table pos_of_roxeleye.stock: ~0 rows (approximately)
REPLACE INTO `stock` (`barcode`, `selling_price`, `qty`, `mfg`, `exp`, `product_id`, `status_id`) VALUES
	(1111, 100, 1, '2024-11-01', '2024-11-23', 8, 1);

-- Dumping structure for table pos_of_roxeleye.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_company1_idx` (`company_id`),
  CONSTRAINT `fk_supplier_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pos_of_roxeleye.supplier: ~0 rows (approximately)
REPLACE INTO `supplier` (`id`, `supplier_name`, `mobile`, `company_id`) VALUES
	(1, 'no', '0', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
employee