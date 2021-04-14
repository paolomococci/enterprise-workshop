CREATE TABLE ateneo_db.presidents_chancellors_relation (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `president_id` bigint(20) unsigned NOT NULL,
  `chancellor_id` bigint(20) unsigned NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `directive` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `presidents_chancellors_relation_president_id_index` (`president_id`),
  KEY `presidents_chancellors_relation_chancellor_id_index` (`chancellor_id`),
  CONSTRAINT `presidents_chancellors_relation_chancellor_id_foreign` FOREIGN KEY (`chancellor_id`) REFERENCES `chancellors` (`id`),
  CONSTRAINT `presidents_chancellors_relation_president_id_foreign` FOREIGN KEY (`president_id`) REFERENCES `presidents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
