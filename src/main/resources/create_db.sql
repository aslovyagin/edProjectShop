-- all CREATE TABLE statements before INSERT INTO for ease of use hsql GUI
-- first execute all CREATE TABLE statements as one script
-- second execute all INSERT INTO statements as one script

DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS client;

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
    login    VARCHAR(100) PRIMARY KEY
                          FOREIGN KEY REFERENCES client (login)
                          ON DELETE CASCADE,
    products INT ARRAY,
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
(0, 'sunglasses', '100', 'super'),
(1, 'watch',      '120', 'wow'),
(2, 'hammer',     '120', 'nice');

INSERT INTO cart (login, products) VALUES
('a', ARRAY[0, 1]),
('b', ARRAY[0]);
