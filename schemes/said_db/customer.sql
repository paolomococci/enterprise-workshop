CREATE TABLE said_db.customer (
  `id` bigint(20) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(20) NOT NULL,
  `important` bit(1) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `occupation` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
