INSERT INTO devices (system_name, type, cost) VALUES ('Windows Workstation', 'Windows Workstation', 4.00);
INSERT INTO devices (system_name, type, cost) VALUES ('Windows Server', 'Windows Server', 4.00);
INSERT INTO devices (system_name, type, cost) VALUES ('Mac', 'Mac', 4.00);

INSERT INTO services_cost (service_name, device_id, cost) VALUES ('Each Device', 1, null);
INSERT INTO services_cost (service_name, device_id, cost) VALUES ('Antivirus Windows', 1, 5.00);
INSERT INTO services_cost (service_name, device_id, cost) VALUES ('Antivirus Mac', 3, 7.00);
INSERT INTO services_cost (service_name, device_id, cost) VALUES ('Backup', 1, 3.00);
INSERT INTO services_cost (service_name, device_id, cost) VALUES ('PSA', 1, 2.00);
INSERT INTO services_cost (service_name, device_id, cost) VALUES ('Screen Share', 1, 1.00);

INSERT INTO user_authenticate (name, email, password) VALUES ('Alejandro Cordero', 'alejandrocorderom23@gmail.com', '$2a$04$oPrVP.echJ0ICBdUw/MnKuyBdoz6u7fPO7TeTr2OADOn0fDclfaxC');