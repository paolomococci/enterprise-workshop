CREATE TABLE capstone_db.machines (
  `id` bigint(20) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
