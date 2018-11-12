CREATE TABLE IF NOT EXISTS tb_customer (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  balance DECIMAL(8, 2),
  discount INT,
  phone_number VARCHAR(255),
  city VARCHAR(255),
  country VARCHAR(255),
  user_id INT
);