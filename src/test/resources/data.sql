DELETE FROM PRICE;
DELETE FROM RESTAURANT;
DELETE FROM DISH;

DELETE FROM ROLE;
DELETE FROM VOTE;
DELETE FROM USER;

ALTER SEQUENCE global_seq RESTART WITH 100000000;

INSERT INTO USER (name, email, password) VALUES
-- ('User', 'user@yandex.ru', '{noop}password'),       -- 100000000
('User', 'user@yandex.ru', '$2a$10$yfT3/Am4LrTFE1.tOYMYC.5aOnkP.rifYbtgrV.GCGBK4n6fFdJAO'),       -- 100000000
('Admin', 'admin@gmail.com', '$2a$10$Xg5Ll9d2w4QZuGfB51zLKOyVNMUhnNVosXP1DQ/Qoo9VxE67nrHYu');        -- 100000001

INSERT INTO ROLE (role, user_id) VALUES
('USER', 100000000),
('ADMIN', 100000001),
('USER', 100000001);

INSERT INTO RESTAURANT (name) VALUES
('Barcelona'),                                      -- 100000002
('Bangkok'),                                        -- 100000003
('Austin');                                         -- 100000004

INSERT INTO DISH (name) VALUES
 ('Cesar'),                                         -- 100000005
 ('Jamon'),                                         -- 100000006
 ('Pescado'),                                       -- 100000007
 ('Greece salad'),                                  -- 100000008
 ('Pasta'),                                         -- 100000009
 ('Pizza'),                                         -- 100000010
 ('Peking duck'),                                   -- 100000011
 ('Rice'),                                          -- 100000012
 ('Piance'),                                        -- 100000013
 ('Kimchi'),                                        -- 100000014
 ('Fruit salad'),                                   -- 100000015
 ('Fried shrimps'),                                 -- 100000016
 ('Steak ribeye'),                                  -- 100000017
 ('Beans'),                                         -- 100000018
 ('Guacamole'),                                     -- 100000019
 ('Burrito'),                                       -- 100000020
 ('Burger'),                                        -- 100000021
 ('Coffee');                                        -- 100000022

INSERT INTO PRICE (date, restaurant_id, dish_id, price) VALUES
('2020-06-01', 100000002, 100000005, 2.90),         -- 100000023
('2020-06-01', 100000002, 100000006, 8.90),         -- 100000024
('2020-06-02', 100000002, 100000007, 8.40),         -- 100000025
('2020-06-02', 100000002, 100000008, 2.99),         -- 100000026
('2020-06-03', 100000002, 100000009, 4.10),         -- 100000027
('2020-06-03', 100000002, 100000010, 5.50),         -- 100000028
('2020-06-01', 100000003, 100000011, 9.90),         -- 100000029
('2020-06-01', 100000003, 100000012, 1.50),         -- 100000030
('2020-06-02', 100000003, 100000013, 1.12),         -- 100000031
('2020-06-02', 100000003, 100000014, 0.57),         -- 100000032
('2020-06-03', 100000003, 100000015, 1.30),         -- 100000033
('2020-06-03', 100000003, 100000016, 10.20),        -- 100000034
('2020-06-01', 100000004, 100000017, 13.99),        -- 100000035
('2020-06-01', 100000004, 100000018, 1.99),         -- 100000036
('2020-06-02', 100000004, 100000019, 3.99),         -- 100000037
('2020-06-02', 100000004, 100000020, 2.99),         -- 100000038
('2020-06-03', 100000004, 100000021, 8.99),         -- 100000039
('2020-06-03', 100000004, 100000022, 0.99);         -- 100000040


INSERT INTO VOTE (date, time, user_id, restaurant_id) VALUES
('2020-06-01', '09:58:00', 100000000, 100000002),               -- 100000041
('2020-06-02', '10:10:15', 100000000, 100000003),               -- 100000042
('2020-06-03', '07:12:13', 100000000, 100000004);               -- 100000043


