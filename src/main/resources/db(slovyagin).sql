CREATE TABLE `onlineShop`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `surName` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8

CREATE TABLE `user` (
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `onlineShop`.`product` (`price`, `name`, `description`) VALUES ('2000', 'iPhone', 'moblile');
INSERT INTO `onlineShop`.`product` (`price`, `name`, `description`) VALUES ('15000', 'OnePlus', 'smartphone');
INSERT INTO `onlineShop`.`product` (`price`, `name`) VALUES ('20000', 'iPhone X');

INSERT INTO `onlineShop`.`client` (`firstName`, `surName`, `status`, `adress`) VALUES ('alexey', 'slovyagin', 'ACTIVE', 'bomzh');
INSERT INTO `onlineShop`.`client` (`firstName`, `surName`, `status`, `adress`) VALUES ('artur', 'ivanov', 'ACTIVE', 'ne bomzh');

INSERT INTO `onlineShop`.`user` (`login`, `password`) VALUES ('allexey', '222');
INSERT INTO `onlineShop`.`user` (`login`, `password`) VALUES ('artur', '333');

