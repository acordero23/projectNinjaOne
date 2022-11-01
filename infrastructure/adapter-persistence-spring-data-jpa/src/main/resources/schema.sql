DROP TABLE IF EXISTS devices;
CREATE TABLE devices (
    id INT PRIMARY KEY auto_increment,
    system_name VARCHAR(150) NOT NULL,
    type VARCHAR(150) NOT NULL,
    cost DECIMAL(18,2) NOT NULL
);

DROP TABLE IF EXISTS services_cost;
CREATE TABLE services_cost (
    id INT PRIMARY KEY auto_increment,
    service_name VARCHAR(150) NOT NULL,
    device_id INT NOT NULL REFERENCES devices (id),
    cost DECIMAL(18,2)
);

DROP TABLE IF EXISTS clients;
CREATE TABLE clients (
    id INT PRIMARY KEY auto_increment,
    client_mame VARCHAR(150) NOT NULL,
    client_identification VARCHAR(150) NOT NULL
);

DROP TABLE IF EXISTS contract;
CREATE TABLE contract (
    id INT PRIMARY KEY auto_increment,
    client_id INT NOT NULL REFERENCES clients (id),
    service_cost_id INT NOT NULL REFERENCES services_cost (id),
    quantity INT NOT NULL
);

DROP TABLE IF EXISTS user_authenticate;
CREATE TABLE user_authenticate (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(150)
);