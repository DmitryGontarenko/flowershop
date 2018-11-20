INSERT INTO tb_user (username, password, role, created_at, updated_at)
              VALUES ('admin', 'admin123', '0', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_customer (first_name, last_name, balance, discount, phone_number, street, city, country, user_id )
                  VALUES ('dmitriy', 'gontarenko', '2000', '3', '89190558053', 'Migalovo', 'Tver', 'Russian', '1');