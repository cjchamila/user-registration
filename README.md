# user-registration
Login url : http://localhost:8585/login
Registration url : http://localhost:8585/registration
Please run the following scripts in a mysql 5.7 instance (since the data.sql is not running them)

use userregdb;
  INSERT INTO country (id,name) VALUES
		(1,'USA');
		
		
 INSERT INTO state (id,name,country_id) VALUES
(1,'Arizona',1),
(2,'California',1),
(3,'Ohio',1),
(4,'Florida',1),
(5,'Chicago',1),
(6,'Texas',1);
