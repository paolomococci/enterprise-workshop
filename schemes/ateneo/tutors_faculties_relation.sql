CREATE TABLE ateneo_db.tutors_faculties_relation (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tutor_id` bigint(20) unsigned NOT NULL,
  `faculty_id` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tutors_faculties_relation_tutor_id_index` (`tutor_id`),
  KEY `tutors_faculties_relation_faculty_id_index` (`faculty_id`),
  CONSTRAINT `tutors_faculties_relation_faculty_id_foreign` FOREIGN KEY (`faculty_id`) REFERENCES `faculties` (`id`),
  CONSTRAINT `tutors_faculties_relation_tutor_id_foreign` FOREIGN KEY (`tutor_id`) REFERENCES `tutors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
