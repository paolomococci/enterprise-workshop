CREATE TABLE capstone_db.contact_customer (
  `contact_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  KEY `FKt2x8mpe4i341vfkm83ib8ihso` (`customer_id`),
  KEY `FKlc7gmvd10v4dmry9ein931kvq` (`contact_id`),
  CONSTRAINT `FKlc7gmvd10v4dmry9ein931kvq` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`),
  CONSTRAINT `FKt2x8mpe4i341vfkm83ib8ihso` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
