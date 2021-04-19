CREATE TABLE ateneo_db.faculties (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `chancellor_id` bigint(20) unsigned DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `faculties_chancellor_id_index` (`chancellor_id`),
  CONSTRAINT `faculties_chancellor_id_foreign` FOREIGN KEY (`chancellor_id`) REFERENCES `chancellors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
