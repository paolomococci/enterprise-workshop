CREATE TABLE capstone_db.invoice_customer (
  `invoice_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  KEY `FKn8aktpc51hsb5ucasrily01oi` (`customer_id`),
  KEY `FKswjwgknf61b8i8qyrwuje6an6` (`invoice_id`),
  CONSTRAINT `FKn8aktpc51hsb5ucasrily01oi` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `FKswjwgknf61b8i8qyrwuje6an6` FOREIGN KEY (`invoice_id`) REFERENCES `invoices` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
