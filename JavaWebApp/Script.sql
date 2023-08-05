--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `CustomerDetails`.`users` DROP PRIMARY KEY;

ALTER TABLE `CustomerDetails`.`users` DROP INDEX `CustomerDetails`.`USER`;

DROP TABLE `CustomerDetails`.`users`;

CREATE TABLE `CustomerDetails`.`users` (
	`id` INT NOT NULL,
	`First_name` VARCHAR(120),
	`Last_name` VARCHAR(120),
	`Address` VARCHAR(120),
	`City` VARCHAR(120),
	`State` VARCHAR(120),
	`Email` VARCHAR(120),
	`Phone` INT,
	PRIMARY KEY (`id`)
);

CREATE UNIQUE INDEX `USER` ON `CustomerDetails`.`users` (null);

