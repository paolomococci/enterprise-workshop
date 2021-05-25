CREATE TABLE said_db.address (
  `id` bigint(20) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `postal_code` varchar(6) NOT NULL,
  `state` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
