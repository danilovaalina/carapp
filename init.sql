CREATE TABLE component
(
    id   int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name varchar(100),
    type varchar (100)
);

CREATE TABLE component_balance
(
    component_id int REFERENCES component (id),
    count        integer
);

CREATE TABLE component_property
(
    component_id int REFERENCES component (id),
    type         varchar(100),
    value        varchar(100)
);

CREATE TABLE car
(
    id   int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY
);

CREATE TABLE car_property
(
    car_id int REFERENCES car (id),
    type         varchar(100),
    value        varchar(100)
);

INSERT INTO component (id, name, type)
VALUES (1, 'white hatchback car body', 'car_body'),
       (2, 'sedan car body', 'car_body'),
       (3, 'r15 wheel', 'car_wheel'),
       (4, 'r16 wheel', 'car_wheel'),
       (5, 'r17 wheel', 'car_wheel');

INSERT INTO component_balance (component_id, count)
VALUES (1, 10),
       (2, 20),
       (3, 30),
       (4, 40),
       (5, 50);

INSERT INTO component_property (component_id, type, value)
VALUES (1, 'car_body_type', 'hatchback'),
       (1, 'car_body_color', 'write'),
       (2, 'car_body_type', 'sedan'),
       (3, 'car_wheel_size', 'R15'),
       (4, 'car_wheel_size', 'R16'),
       (5, 'car_wheel_size', 'R17')