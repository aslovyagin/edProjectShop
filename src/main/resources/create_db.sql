 -- all CREATE TABLE statements before INSERT INTO for ease of use hsql GUI
-- first execute all CREATE TABLE statements as one script
-- second execute all INSERT INTO statements as one script

--DELETE FROM client;
--DELETE FROM product;
--DELETE FROM cart;

--DROP TABLE IF EXISTS cart_product;
--DROP TABLE IF EXISTS cart;
--DROP TABLE IF EXISTS product;
--DROP TABLE IF EXISTS user;
--DROP TABLE IF EXISTS client;

CREATE TABLE client (
      login     VARCHAR(100) PRIMARY KEY,
      firstName VARCHAR(100) NOT NULL,
      lastName  VARCHAR(100) NOT NULL,
      status    VARCHAR(100) NOT NULL
);

CREATE TABLE user (
  login    VARCHAR(100) PRIMARY KEY
                        FOREIGN KEY REFERENCES client (login)
                        ON DELETE CASCADE,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE product (
  id          IDENTITY,
  title       VARCHAR(100) NOT NULL,
  price       INT          NOT NULL,
  description VARCHAR(100) NOT NULL
);

CREATE TABLE cart (
  id            IDENTITY,
  login         VARCHAR(100) FOREIGN KEY REFERENCES client (login)
                     ON DELETE CASCADE,
  purchase_date TIMESTAMP
);

CREATE TABLE cart_product (
    cart_id       INT FOREIGN KEY REFERENCES cart (id)
                  ON DELETE CASCADE,
    product_id    INT FOREIGN KEY REFERENCES product (id)
                  ON DELETE CASCADE,
    product_count INT NOT NULL
);


INSERT INTO client (login, lastName, firstName, status) VALUES
('a', 'Словягин', 'Алекей', 'ADMIN'),
('b', 'Лагойко',  'Руслан', 'ACTIVE'),
('c', 'Акбаров',  'Артур',  'BLOCKED');

INSERT INTO user (login, password) VALUES
('a', 'a'),
('b', 'b'),
('c', 'c');

INSERT INTO product (id, title, price, description) VALUES
(1, 'sunglasses', '100', 'super'),
(2, 'watch',      '120', 'wow'),
(3, 'hammer',     '120', 'nice');

INSERT INTO cart (id, login, purchase_date) VALUES
(1, 'a', '2017-10-23 17:30:00'),
(2, 'a', '2017-10-23 20:40:00'),
(3, 'b', '2017-10-23 16:30:00'),
(4, 'c', '2017-10-23 15:30:00'),
(5, 'a', NULL),
(6, 'c', NULL),
(7, 'b', NULL);

INSERT INTO cart_product (cart_id, product_id, product_count) VALUES
(1, 2, 3),
(1, 1, 1),
(2, 3, 3),
(3, 1, 1),
(4, 1, 5),
(5, 3, 1),
(6, 2, 2),
(6, 1, 1),
(7, 3, 1);
