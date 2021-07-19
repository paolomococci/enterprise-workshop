CREATE TABLE capstone_db.suppliers (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sticker` varchar(255) DEFAULT NULL,
  `updated` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
