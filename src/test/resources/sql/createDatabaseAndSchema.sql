CREATE DATABASE  IF NOT EXISTS `workinfo`;
CREATE USER 'workinfouser'@'localhost' IDENTIFIED BY 'workinfouser';
GRANT ALL PRIVILEGES ON workinfo.* TO 'workinfouser'@'localhost' WITH GRANT OPTION;
ALTER USER 'workinfouser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'workinfouser';
USE `workinfo`;

--
-- Table structure for table `info_node`
--
DROP TABLE IF EXISTS `info_node`;
CREATE TABLE `info_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `node_order` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `parent_node_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by_user` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKInfoNodeParentNode` (`parent_node_id`),
  CONSTRAINT `FKInfoNodeParentNode` FOREIGN KEY (`parent_node_id`) REFERENCES `info_node` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Table structure for table `info_unit`
--
DROP TABLE IF EXISTS `info_unit`;
CREATE TABLE `info_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `info_node_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by_user` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKInfoUnitInfoNode` (`info_node_id`),
  CONSTRAINT `FKInfoUnitInfoNode` FOREIGN KEY (`info_node_id`) REFERENCES `info_node` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Table structure for table `info_attribute`
--
DROP TABLE IF EXISTS `info_attribute`;
CREATE TABLE `info_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `info_unit_id` bigint(20) DEFAULT NULL,
  `attribute_name` varchar(255) DEFAULT NULL,
  `attribute_value` varchar(4000) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by_user` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKInfoAttrInfoUnit` (`info_unit_id`),
  CONSTRAINT `FKInfoAttrInfoUnit` FOREIGN KEY (`info_unit_id`) REFERENCES `info_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;