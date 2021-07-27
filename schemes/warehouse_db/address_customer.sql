CREATE TABLE warehouse_db.address_customer (
  `address_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  KEY `FKfuxkjh2xs60fcuwvfyfddyr9i` (`customer_id`),
  KEY `FK9acspv6ike5vy03imppenv7qw` (`address_id`),
  CONSTRAINT `FK9acspv6ike5vy03imppenv7qw` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `FKfuxkjh2xs60fcuwvfyfddyr9i` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
