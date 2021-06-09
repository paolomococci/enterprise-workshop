CREATE TABLE capstone_db.invoices (
  `id` bigint(20) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
