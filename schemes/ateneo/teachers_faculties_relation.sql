CREATE TABLE ateneo_db.teachers_faculties_relation (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint(20) unsigned NOT NULL,
  `faculty_id` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teachers_faculties_relation_teacher_id_index` (`teacher_id`),
  KEY `teachers_faculties_relation_faculty_id_index` (`faculty_id`),
  CONSTRAINT `teachers_faculties_relation_faculty_id_foreign` FOREIGN KEY (`faculty_id`) REFERENCES `faculties` (`id`),
  CONSTRAINT `teachers_faculties_relation_teacher_id_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
