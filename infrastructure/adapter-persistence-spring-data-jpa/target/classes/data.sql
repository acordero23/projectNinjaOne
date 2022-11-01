INSERT INTO devices (id, system_name, type, cost) VALUES (1, 'Windows', 'Windows Workstation', 4.00);
INSERT INTO devices (id, system_name, type, cost) VALUES (2, 'Windows', 'Windows Server', 4.00);
INSERT INTO devices (id, system_name, type, cost) VALUES (3, 'Mac', 'Mac', 4.00);

INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (1, 'Each Device', 1, 4.00);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (2, 'Antivirus windows', 1, 5.00);
INSERT INTO services_cost (id, service_name, device_id, cost) VALUES (3, 'Antivirus mac', 3, 7.00);