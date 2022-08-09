CREATE TABLE client (
  id bigint NOT NULL,
  email varchar(255) NOT NULL,
  name varchar(100) NOT NULL,
  phone varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ;
