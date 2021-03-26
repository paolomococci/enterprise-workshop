CREATE TABLE food_cart_db.ingredient_recipe_relation (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) unsigned NOT NULL,
  `recipe_id` bigint(20) unsigned NOT NULL,
  `quantity` decimal(5,3) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ingredient_recipe_relation_ingredient_id_index` (`ingredient_id`),
  KEY `ingredient_recipe_relation_recipe_id_index` (`recipe_id`),
  CONSTRAINT `ingredient_recipe_relation_ingredient_id_foreign` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`),
  CONSTRAINT `ingredient_recipe_relation_recipe_id_foreign` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
