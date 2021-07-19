CREATE TABLE capstone_db.components (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `component_invoice_fk` bigint(20) DEFAULT NULL,
  `component_product_fk` bigint(20) DEFAULT NULL,
  `component_supplier_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhhxsr674lwxxbi0i9tiq06431` (`component_invoice_fk`),
  KEY `FKaxk30ttx2hwyuhkkvcj2rc9k4` (`component_product_fk`),
  KEY `FKo9ejfw6yang7q3y7tvqgyebdq` (`component_supplier_fk`),
  CONSTRAINT `FKaxk30ttx2hwyuhkkvcj2rc9k4` FOREIGN KEY (`component_product_fk`) REFERENCES `products` (`id`),
  CONSTRAINT `FKhhxsr674lwxxbi0i9tiq06431` FOREIGN KEY (`component_invoice_fk`) REFERENCES `invoices` (`id`),
  CONSTRAINT `FKo9ejfw6yang7q3y7tvqgyebdq` FOREIGN KEY (`component_supplier_fk`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
