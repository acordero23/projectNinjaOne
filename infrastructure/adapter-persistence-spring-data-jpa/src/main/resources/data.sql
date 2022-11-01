INSERT INTO devices (id, system_name, type, cost) VALUES (1, 'Windows Workstation', 'Windows Workstation', 4.00);
INSERT INTO devices (id, system_name, type, cost) VALUES (2, 'Windows Server', 'Windows Server', 4.00);
INSERT INTO devices (id, system_name, type, cost) VALUES (3, 'Mac', 'Mac', 4.00);

INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (1, 'Each Device', 1, null);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (2, 'Antivirus Windows', 1, 5.00);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (3, 'Antivirus Mac', 3, 7.00);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (4, 'Backup', 1, 3.00);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (5, 'PSA', 1, 2.00);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (6, 'Screen Share', 1, 1.00);

INSERT INTO user_authenticate (id, name, email, password) VALUES (1, 'Alejandro Cordero', 'alejandrocorderom23@gmail.com', '$2a$04$oPrVP.echJ0ICBdUw/MnKuyBdoz6u7fPO7TeTr2OADOn0fDclfaxC');