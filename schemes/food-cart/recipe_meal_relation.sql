CREATE TABLE food_cart_db.recipe_meal_relation (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `recipe_id` bigint(20) unsigned NOT NULL,
  `meal_id` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recipe_meal_relation_recipe_id_index` (`recipe_id`),
  KEY `recipe_meal_relation_meal_id_index` (`meal_id`),
  CONSTRAINT `recipe_meal_relation_meal_id_foreign` FOREIGN KEY (`meal_id`) REFERENCES `meals` (`id`),
  CONSTRAINT `recipe_meal_relation_recipe_id_foreign` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
