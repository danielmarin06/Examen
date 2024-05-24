CREATE TABLE `examen`.`projects` (
	id_project INT AUTO_INCREMENT PRIMARY KEY,
	project_name VARCHAR(200),
	manager VARCHAR(200),
	details TEXT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);		
							
CREATE TABLE `examen`.`tasks` (
	id_task INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(200),
	description VARCHAR(200),
	status VARCHAR(200),	
	priority INT,
	id_project INT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (id_project) REFERENCES projects(id_project)
);


INSERT INTO `examen`.`projects` (project_name, manager, details) 
VALUES ('Examen', 'Oscar Mesa', 'Poner un examen duro.');

INSERT INTO `examen`.`projects` (project_name, manager, details) 
VALUES ('Ganar examen', 'Daniel Marin', 'Ganar el examen.');


INSERT INTO `examen`.`tasks` (title, description, status, priority, id_project) 
VALUES ('Objetivos', 'Poner objetivos duros', 'Realizado', 1, 1);

INSERT INTO `examen`.`tasks` (title, description, status, priority, id_project) 
VALUES ('Servlet', 'Enviar peticiones postman', 'Fallido', 1, 2);


