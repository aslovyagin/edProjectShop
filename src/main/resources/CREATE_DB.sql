CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `surName` varchar(45) NOT NULL,
  `statusClient` varchar(45) NOT NULL,
  `adress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `onlineShop`.`client` (`firstName`, `surName`, `statusClient`, `adress`) VALUES ('allexey', 'slovyagin', 'ACTIVE', 'bomzh');
INSERT INTO `onlineShop`.`client` (`firstName`, `surName`, `statusClient`, `adress`) VALUES ('artur', 'ivanov', 'ACTIVE', 'ne bomzh');

INSERT INTO `onlineShop`.`user` (`id`, `login`, `password`) VALUES ('59', 'al', '222');
INSERT INTO `onlineShop`.`user` (`id`, `login`, `password`) VALUES ('60', 'ar', '333');


