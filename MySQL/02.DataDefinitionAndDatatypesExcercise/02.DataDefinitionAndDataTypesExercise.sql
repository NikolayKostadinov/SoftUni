CREATE DATABASE `minions`;

-- 01. Create Tables
CREATE TABLE `minions` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` INT NOT NULL
);

CREATE TABLE `towns` (
    `town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

-- 02. Alter Minions Table
-- ALTER TABLE `towns` RENAME COLUMN `town_id` TO `id`;
ALTER TABLE `minions` ADD COLUMN `town_id` INT NOT NULL,
					  ADD FOREIGN KEY (`town_id`) 
						  REFERENCES `towns`(`id`);
                          
-- 03. Insert Records in Both Tables
INSERT INTO `towns`(`id`,`name`)
VALUES(1, 'Sofia'),
	  (2, 'Plovdiv'),
	  (3, 'Varna');
      
INSERT INTO `minions`(`id`, `name`, `age`, `town_id`)
VALUES(1, 'Kevin',	22,	1),
	  (2, 'Bob', 15, 3),
	  (3, 'Steward', NULL,	2);
      
-- 04. Truncate Table Minions
TRUNCATE TABLE `minions`;

-- 05. Drop All Tables
DROP TABLE `minions`;
DROP TABLE `towns`;

-- 06. Create Table People
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DECIMAL(65, 2),
`weight` DECIMAL(65, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATETIME not null,
`biography` TEXT);

INSERT INTO `people`(`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES
	('Pesho', NULL, 1.85, 100, 'm', '1977-02-01 10:11:12',''),
	('Pesho', NULL, 1.85, 100, 'm', '1977-02-01 10:11:12',''),
	('Pesho', NULL, 1.85, 100, 'm', '1977-02-01 10:11:12',''),
	('Pesho', NULL, 1.85, 100, 'm', '1977-02-01 10:11:12',''),
	('Pesho', NULL, 1.85, 100, 'm', '1977-02-01 10:11:12','');
    
-- 07. Create Table Users
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL,
	`password` VARCHAR(26) NOT NULL,
	`profile_picture` BLOB,
	`last_login_time` DATETIME,
    `is_deleted` BOOLEAN
);

INSERT INTO `users`(`username`, `password`, `last_login_time`, `is_deleted`)
VALUES
	('pesho1', 'test', NULL, TRUE),
	('pesho2', 'test', NULL, FALSE),
	('pesho3', 'test', '2022-01-11 14:19', FALSE),
	('pesho4', 'test', NULL, FALSE),
	('pesho5', 'test', NULL, TRUE);

-- 08. Change Primary Key
ALTER TABLE `users` DROP PRIMARY KEY,
					ADD PRIMARY KEY(`id`, `username`);
                    
-- 9. Set Default Value of a Field
ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME DEFAULT NOW();

-- 10. Set Unique Field
ALTER TABLE `users` DROP PRIMARY KEY,
					ADD PRIMARY KEY(`id`),
                    ADD UNIQUE(`username`);
                    
-- 11. Movies Database
DROP TABLE IF EXISTS `directors`, `genres`, `categories`, `movies`;
CREATE TABLE `directors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`director_name` VARCHAR(50) NOT NULL, 
	`notes` TEXT);
    
CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`genre_name` VARCHAR(50) NOT NULL, 
	`notes` TEXT);

CREATE TABLE `categories` (
	`id`INT PRIMARY KEY AUTO_INCREMENT, 
    `category_name` VARCHAR(50) NOT NULL, 
    `notes` TEXT); 
    
CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`title` VARCHAR(200) NOT NULL, 
`director_id` INT NOT NULL, 
`copyright_year` INT NOT NULL, 
`length` INT NOT NULL, 
`genre_id` INT NOT NULL, 
`category_id` INT NOT NULL, 
`rating` DECIMAL(2,1) UNSIGNED NOT NULL, 
`notes` TEXT);
    
INSERT INTO `directors`(`director_name`)
    VALUES ('George Lucas'),
		   ('Nikita Mihalkov'), 
		   ('Quentin Tarantino'), 
		   ('Steven Spielberg'), 
		   ('Martin Scorsese');
           
INSERT INTO `genres`(`genre_name`)
    VALUES ('Si-Fi'),
		   ('Drama'), 
		   ('Action'), 
		   ('Crime'), 
		   ('Biography');

           
INSERT INTO `categories`(`category_name`)
    VALUES ('Movie'),
		   ('Series'), 
		   ('Animation'), 
		   ('B&W'), 
		   ('Other');
           
INSERT INTO `movies`(`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`)
VALUES
	('Star Wars: Episode IV - A New Hope', 1, 1977, 121, 1, 1, 8.6),
	('Burnt by the Sun', 2, 1994, 135, 2, 1, 7.9),
	('Pulp Fiction', 3, 1994, 154, 3, 1, 8.6),
	('West Side Story', 4, 2021, 156, 4, 5, 8.6),
	('Taxi Driver', 5, 1976, 114, 1, 1, 8.2);
    