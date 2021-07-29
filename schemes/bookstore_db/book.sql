CREATE TABLE bookstore_db.book (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `publication` date DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `image` longtext DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ehpdfjpu1jm3hijhj4mm0hx9h` (`isbn`),
  UNIQUE KEY `UK8hff8kqj9m4xnnfe52ddib172` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
