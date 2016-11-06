use Orders;
CREATE TABLE `product` (`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
                       `name` VARCHAR(25) DEFAULT NULL,
                       `price` DECIMAL(15) NOT NULL,
  PRIMARY KEY (`id`));



CREATE TABLE `client` (`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
                        `first_name` VARCHAR(25) DEFAULT NULL,
                        `second_name` VARCHAR(50) NOT NULL,
                        `age` INTEGER(4) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `order1` (`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
                        `product_id` VARCHAR(25) DEFAULT NULL,
                        `client_id` VARCHAR(50) NOT NULL,
                        `number1` INTEGER(4) NOT NULL,
                        `total_price` DECIMAL(15) NOT NULL,
  PRIMARY KEY (`id`));



