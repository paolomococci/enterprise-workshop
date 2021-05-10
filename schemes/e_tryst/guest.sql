CREATE TABLE e_tryst_db.guest (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `tryst_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_ACB79A35D9CD6CFE` (`tryst_id`),
  CONSTRAINT `FK_ACB79A35D9CD6CFE` FOREIGN KEY (`tryst_id`) REFERENCES `tryst` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
