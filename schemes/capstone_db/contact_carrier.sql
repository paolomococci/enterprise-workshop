CREATE TABLE capstone_db.contact_carrier (
  `contact_id` bigint(20) NOT NULL,
  `carrier_id` bigint(20) NOT NULL,
  KEY `FKecjinbe5br17ag7doc4yku4ka` (`carrier_id`),
  KEY `FKl8rgoihy2yc0lemd478hk66fj` (`contact_id`),
  CONSTRAINT `FKecjinbe5br17ag7doc4yku4ka` FOREIGN KEY (`carrier_id`) REFERENCES `carriers` (`id`),
  CONSTRAINT `FKl8rgoihy2yc0lemd478hk66fj` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
