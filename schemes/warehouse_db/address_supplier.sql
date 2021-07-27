CREATE TABLE warehouse_db.address_supplier (
  `address_id` bigint(20) NOT NULL,
  `supplier_id` bigint(20) NOT NULL,
  KEY `FKacurc6548mehr1jv4kbjre9dl` (`supplier_id`),
  KEY `FKehbhwy1cmtftoomkt0vkh2gln` (`address_id`),
  CONSTRAINT `FKacurc6548mehr1jv4kbjre9dl` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `FKehbhwy1cmtftoomkt0vkh2gln` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
