DROP TABLE IF EXISTS devices;

CREATE TABLE devices (
    id INT PRIMARY KEY auto_increment,
    system_name VARCHAR(150) NOT NULL,
    type VARCHAR(150) NOT NULL,
    cost DECIMAL(18,2) NOT NULL
);