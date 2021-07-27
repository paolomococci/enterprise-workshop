CREATE TABLE warehouse_db.capacities (
  `id` bigint(20) NOT NULL,
  `created` datetime(6) NOT NULL,
  `updated` datetime(6) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `useful_volume` int(11) DEFAULT NULL,
  `useful_weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
