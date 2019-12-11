DROP TABLE IF EXISTS k_empl;
  
CREATE TABLE k_empl (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  created_at datetime NOT NULL,
  updated_at datetime NOT NULL
);

INSERT INTO K_EMPL (first_name, last_name, email,created_at, updated_at) VALUES
  ('Lokesh', 'Gupta', 'abc@gmail.com','2017-06-15','2017-06-15'),
  ('Deja', 'Vu', 'xyz@email.com','2017-06-15','2017-06-15'),
  ('Caption', 'America', 'cap@marvel.com','2017-06-15','2017-06-15');