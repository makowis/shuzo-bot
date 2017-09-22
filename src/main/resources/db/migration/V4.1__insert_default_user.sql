-- id = admin, password=password
INSERT INTO Users(user_id,password,enabled) VALUES ('admin', '$2a$10$MFNKDnq7EgpoxxylzwbJPePKSXJqN7pbtF062EMXxJ4sq9Ibnf8lW', TRUE );
INSERT INTO Authorities(user_id, role) VALUES ('admin', 'ADMIN');