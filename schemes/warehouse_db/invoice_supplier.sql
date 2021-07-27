CREATE TABLE warehouse_db.invoice_supplier (
  `invoice_id` bigint(20) NOT NULL,
  `supplier_id` bigint(20) NOT NULL,
  KEY `FK3b7esy3sevu4lm9qr7jju52go` (`supplier_id`),
  KEY `FKcoph06mrd4otnua73o0g5lgnm` (`invoice_id`),
  CONSTRAINT `FK3b7esy3sevu4lm9qr7jju52go` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `FKcoph06mrd4otnua73o0g5lgnm` FOREIGN KEY (`invoice_id`) REFERENCES `invoices` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
