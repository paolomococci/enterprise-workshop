CREATE TABLE capstone_db.invoice_carrier (
  `invoice_id` bigint(20) NOT NULL,
  `carrier_id` bigint(20) NOT NULL,
  KEY `FKbyyhikt1k8mdod4ys6u5iydhh` (`carrier_id`),
  KEY `FK4legayctg723l1qoqpqfs673b` (`invoice_id`),
  CONSTRAINT `FK4legayctg723l1qoqpqfs673b` FOREIGN KEY (`invoice_id`) REFERENCES `invoices` (`id`),
  CONSTRAINT `FKbyyhikt1k8mdod4ys6u5iydhh` FOREIGN KEY (`carrier_id`) REFERENCES `carriers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
