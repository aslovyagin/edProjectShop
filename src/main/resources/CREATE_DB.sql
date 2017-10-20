CREATE TABLE user (
    id int NOT NULL,
    firstName varchar(100) NOT NULL,
    lastName varchar(100) NOT NULL,
    login varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO user (id, lastName, firstName, login, password) VALUES (0, 'Словягин', 'Алекей', 'a', 'a');
INSERT INTO user (id, lastName, firstName, login, password) VALUES (1, 'Лагойко', 'Руслан', 'b', 'b');
INSERT INTO user (id, lastName, firstName, login, password) VALUES (2, 'Акбаров', 'Артур', 'c', 'c');

CREATE TABLE product (
    id int NOT NULL,
    name varchar(100) NOT NULL,
    price int NOT NULL,
    description varchar(100) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO product (id, name, price, description) VALUES (0, 'film part1', '100', 'super');
INSERT INTO product (id, name, price, description) VALUES (1, 'film part2', '120', 'wow');
