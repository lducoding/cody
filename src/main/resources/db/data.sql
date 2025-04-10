-- brand data insert
INSERT INTO brand (name, created_at, updated_at)
VALUES ('A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('D', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('E', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('F', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('H', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('I', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand A product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 11200, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 5500, 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 4200, 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9000, 1, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2000, 1, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1700, 1, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 1800, 1, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2300, 1, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand B product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 10500, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 5900, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3800, 2, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9100, 2, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2100, 2, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 2000, 2, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2000, 2, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2200, 2, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand C product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 10000, 3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 6200, 3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3300, 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9200, 3, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2200, 3, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1900, 3, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2200, 3, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2100, 3, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand D product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 10100, 4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 5100, 4, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3000, 4, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9500, 4, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2500, 4, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1500, 4, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2400, 4, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2000, 4, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand E product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 10700, 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 5000, 5, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3800, 5, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9900, 5, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2300, 5, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1800, 5, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2100, 5, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2100, 5, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand F product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 11200, 6, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 7200, 6, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 4000, 6, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9300, 6, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2100, 6, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1600, 6, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2300, 6, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 1900, 6, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand G product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 10500, 7, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 5800, 7, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3900, 7, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9000, 7, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2200, 7, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1700, 7, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2100, 7, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2000, 7, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand H product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 10800, 8, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 6300, 8, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3100, 8, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9700, 8, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2100, 8, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1600, 8, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 2000, 8, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2000, 8, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- brand I product insert
INSERT INTO product (category, price, brand_id, category_order_number, created_at, updated_at)
VALUES ('TOP', 11400, 9, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('OUTER', 6700, 9, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PANTS', 3200, 9, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SNEAKERS', 9500, 9, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('BAG', 2400, 9, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('HAT', 1700, 9, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SOCKS', 1700, 9, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ACCESSORIES', 2400, 9, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);