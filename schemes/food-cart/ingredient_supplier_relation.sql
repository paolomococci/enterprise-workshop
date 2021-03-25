CREATE TABLE food_cart_db.ingredient_supplier_relation (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) unsigned NOT NULL,
  `supplier_id` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ingredient_supplier_relation_ingredient_id_index` (`ingredient_id`),
  KEY `ingredient_supplier_relation_supplier_id_index` (`supplier_id`),
  CONSTRAINT `ingredient_supplier_relation_ingredient_id_foreign` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`),
  CONSTRAINT `ingredient_supplier_relation_supplier_id_foreign` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
