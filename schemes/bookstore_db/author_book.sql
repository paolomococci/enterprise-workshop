CREATE TABLE bookstore_db.author_book (
  `author_id` bigint(20) NOT NULL,
  `book_id` bigint(20) NOT NULL,
  KEY `FKn8665s8lv781v4eojs8jo3jao` (`book_id`),
  KEY `FKg7j6ud9d32ll232o9mgo90s57` (`author_id`),
  CONSTRAINT `FKg7j6ud9d32ll232o9mgo90s57` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKn8665s8lv781v4eojs8jo3jao` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
