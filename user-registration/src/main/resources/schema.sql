CREATE DATABASE IF NOT EXISTS userregdb;

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `state` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcy8jtacko1alc76so2r6xk815` (`country_id`),
  CONSTRAINT `FKcy8jtacko1alc76so2r6xk815` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop procedure if exists userregdb.findStatesForCountry;

DELIMITER $$ 
Create PROCEDURE userregdb.findStatesForCountry(
						  
						   IN country_name varchar(255)
						   )
 BEGIN
select name from state where country_id=(select id from country where name ='country_name');
 END $$
 DELIMITER ;
 
 
 drop procedure if exists userregdb.findStatesForCountry;$$
DELIMITER $$ 
Create PROCEDURE userregdb.saveUser(
						   IN addr1 varchar(255), 
						   IN addr2 varchar(255),
						   IN city varchar(255),
						   IN zipcode INT,
						   IN country varchar(255),
						   IN name varchar(255),
						   IN phone INT,
						   IN state varchar(255),
						   IN user_id INT)
 BEGIN
 insert into user(name, address, subject) values (p_id, p_name,p_address, p_subject);
 END $$
DELIMITER ;