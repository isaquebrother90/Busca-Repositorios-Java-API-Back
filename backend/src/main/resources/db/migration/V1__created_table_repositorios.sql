CREATE TABLE IF NOT EXISTS repositorios (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  image varchar(200) DEFAULT NULL,
  name varchar(150) NOT NULL,
  stars int(40) NOT NULL,
  forks int(40) NOT NULL
);