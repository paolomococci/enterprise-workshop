CREATE TABLE food_cart_db.meals (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  category varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  description mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  price decimal(8,3) NOT NULL,
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
