CREATE TABLE capstone_db.products (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
