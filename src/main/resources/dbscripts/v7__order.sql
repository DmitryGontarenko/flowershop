CREATE TABLE IF NOT EXISTS tb_order (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  total DECIMAL (8,2),
  status SMALLINT DEFAULT 0,
  customer_id INT NOT NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,

  CONSTRAINT fk_customer_id
    FOREIGN KEY (customer_id)
    REFERENCES tb_customer (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

