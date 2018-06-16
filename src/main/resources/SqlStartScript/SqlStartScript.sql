CREATE SCHEMA `test_task` ;

CREATE TABLE `test_task`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_type` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC));

CREATE TABLE `test_task`.`requests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `request` VARCHAR(45) NOT NULL,
  `bid` INT NOT NULL,
  `due_date` DATETIME NOT NULL,
  `is_completed` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

INSERT INTO `test_task`.`users` (`id`, `login`, `password`, `user_type`) VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `test_task`.`users` (`id`, `login`, `password`, `user_type`) VALUES ('2', 'user', 'user', '2');
