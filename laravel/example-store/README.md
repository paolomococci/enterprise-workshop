# example-store developed thanks to Laravel framework

## some preparatory steps:
1. make sure you have installed php-mysql, to verify this, you can add an info path to your file routes/web.php, type the link in your browser and look for the presence of driver in the PDO section
```
Route::get('/info', function () {
    phpinfo();
});
```
2. create database example_store
```
CREATE DATABASE example_store;
```
3. create table item
```
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
```
