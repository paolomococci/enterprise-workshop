CREATE TABLE warehouse_db.crews (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `crew_machine_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK27lkeb4yaa3y3h1isdbb7roub` (`crew_machine_fk`),
  CONSTRAINT `FK27lkeb4yaa3y3h1isdbb7roub` FOREIGN KEY (`crew_machine_fk`) REFERENCES `machines` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
