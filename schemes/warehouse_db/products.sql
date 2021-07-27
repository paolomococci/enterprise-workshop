CREATE TABLE warehouse_db.products (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `product_customer_fk` bigint(20) DEFAULT NULL,
  `product_invoice_fk` bigint(20) DEFAULT NULL,
  `product_machine_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0yyk4kkpn2oai4jhctg9by5q` (`product_customer_fk`),
  KEY `FKnhy3d549hvjk1hct1urlfxuio` (`product_invoice_fk`),
  KEY `FKjxae5vjaqwvqbqfp4tdoo4iep` (`product_machine_fk`),
  CONSTRAINT `FKh0yyk4kkpn2oai4jhctg9by5q` FOREIGN KEY (`product_customer_fk`) REFERENCES `customers` (`id`),
  CONSTRAINT `FKjxae5vjaqwvqbqfp4tdoo4iep` FOREIGN KEY (`product_machine_fk`) REFERENCES `machines` (`id`),
  CONSTRAINT `FKnhy3d549hvjk1hct1urlfxuio` FOREIGN KEY (`product_invoice_fk`) REFERENCES `invoices` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
