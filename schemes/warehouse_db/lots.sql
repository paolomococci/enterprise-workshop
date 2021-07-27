CREATE TABLE warehouse_db.lots (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `deadline` date DEFAULT NULL,
  `lot_component_fk` bigint(20) DEFAULT NULL,
  `lot_product_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn846hjdbebuc5yttac1417bbs` (`lot_component_fk`),
  KEY `FK77b6m3qkfagasqxs72gcs7er5` (`lot_product_fk`),
  CONSTRAINT `FK77b6m3qkfagasqxs72gcs7er5` FOREIGN KEY (`lot_product_fk`) REFERENCES `products` (`id`),
  CONSTRAINT `FKn846hjdbebuc5yttac1417bbs` FOREIGN KEY (`lot_component_fk`) REFERENCES `components` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
