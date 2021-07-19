CREATE TABLE capstone_db.operators (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `updated` datetime(6) NOT NULL,
  `contributory_identifier` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `operator_crew_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKebf19qgrbiqwhcgvt2ppb76bk` (`operator_crew_fk`),
  CONSTRAINT `FKebf19qgrbiqwhcgvt2ppb76bk` FOREIGN KEY (`operator_crew_fk`) REFERENCES `crews` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
