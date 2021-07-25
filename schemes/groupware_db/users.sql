CREATE TABLE groupware_db.users (
  `id` bigint(20) NOT NULL,
  `hashed_password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `profile_image_url` longtext DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
