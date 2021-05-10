CREATE TABLE e_tryst_db.post (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `merit` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `at` datetime NOT NULL,
  `guest_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5A8A6C8D9A4AA658` (`guest_id`),
  CONSTRAINT `FK_5A8A6C8D9A4AA658` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
