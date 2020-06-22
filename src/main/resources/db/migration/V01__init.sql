-- Script para crear la base de datos empleosdb (MySQL 8.0)

DROP TABLE IF EXISTS `editoriales`;
CREATE TABLE `editoriales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `perfiles`;
CREATE TABLE `perfiles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `perfil` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `estatus` int NOT NULL DEFAULT '1',
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(30) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `destacado` int NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `published_date` datetime(6) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `detalles` text,
  `id_editorial` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_books_editoriales1_idx` (`id_editorial`),
  CONSTRAINT `fk_books_editoriales1` FOREIGN KEY (`id_editorial`) REFERENCES `editoriales` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `solicitudes`;
CREATE TABLE `solicitudes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `comentarios` text,
  `id_book` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_usuario_UNIQUE` (`id_book`,`id_usuario`),
  KEY `fk_solicitudes_books1_idx` (`id_book`),
  KEY `fk_solicitudes_usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_solicitudes_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_solicitudes_books1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `usuario_perfil`;
CREATE TABLE `usuario_perfil` (
  `id_usuario` int NOT NULL,
  `id_perfil` int NOT NULL,
  UNIQUE KEY `usuario_perfil_UNIQUE` (`id_usuario`,`id_perfil`),
  KEY `fk_usuarios1_idx` (`id_usuario`),
  KEY `fk_perfiles1_idx` (`id_perfil`),
  CONSTRAINT `fk_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_perfiles1` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Crear tabla de usuarios
CREATE TABLE `users` (
	`username` varchar(50) NOT NULL,
	`password` varchar(50) NOT NULL,
	`enabled` tinyint(1) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB;

-- Crear tabla de roles
CREATE TABLE `authorities` (
	`username` varchar(50) NOT NULL,
	`authority` varchar(50) NOT NULL,
	UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
	CONSTRAINT `authorities_ibfk_1`
	FOREIGN KEY (`username`)
	REFERENCES `users` (`username`)
) ENGINE=InnoDB;
