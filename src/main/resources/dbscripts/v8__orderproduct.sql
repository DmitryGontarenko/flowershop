CREATE TABLE IF NOT EXISTS tb_order_product (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  order_id INT NOT NULL,
  product_id INT NOT NULL REFERENCES tb_product(id),
  quantity INT,

  CONSTRAINT fk_order_id
    FOREIGN KEY (order_id)
    REFERENCES tb_order (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_product_id
    FOREIGN KEY (product_id)
    REFERENCES tb_product (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);