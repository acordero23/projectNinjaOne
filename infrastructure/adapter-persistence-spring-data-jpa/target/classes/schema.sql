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
    cost DECIMAL(18,2) NOT NULL
);