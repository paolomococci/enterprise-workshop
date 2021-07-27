CREATE TABLE warehouse_db.contact_supplier (
  `contact_id` bigint(20) NOT NULL,
  `supplier_id` bigint(20) NOT NULL,
  KEY `FKxv6gsrxvp4bngprg4vp8yf0n` (`supplier_id`),
  KEY `FKefmga20ed9na758iscwyaqd7k` (`contact_id`),
  CONSTRAINT `FKefmga20ed9na758iscwyaqd7k` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`),
  CONSTRAINT `FKxv6gsrxvp4bngprg4vp8yf0n` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
