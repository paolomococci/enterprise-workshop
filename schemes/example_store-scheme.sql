CREATE DATABASE example_store;

CREATE TABLE example_store.item (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NULL,
	description varchar(100) NULL,
	price DECIMAL NULL,
	updated DATETIME NULL,
	CONSTRAINT item_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
