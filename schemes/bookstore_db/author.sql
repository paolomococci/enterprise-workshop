CREATE TABLE bookstore_db.author (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_710u6nck5puv97xwk9chiwk7p` (`alias`),
  UNIQUE KEY `UKsjel57mnyyx954vc7hchfnodn` (`alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
