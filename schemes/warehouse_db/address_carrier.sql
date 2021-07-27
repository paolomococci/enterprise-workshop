CREATE TABLE warehouse_db.address_carrier (
  `address_id` bigint(20) NOT NULL,
  `carrier_id` bigint(20) NOT NULL,
  KEY `FKgry38o4cr15n14fpfhx10dwa9` (`carrier_id`),
  KEY `FKtfc8qvt5ljyhb2elal4yhyho8` (`address_id`),
  CONSTRAINT `FKgry38o4cr15n14fpfhx10dwa9` FOREIGN KEY (`carrier_id`) REFERENCES `carriers` (`id`),
  CONSTRAINT `FKtfc8qvt5ljyhb2elal4yhyho8` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
