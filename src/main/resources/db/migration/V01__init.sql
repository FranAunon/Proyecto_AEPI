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
  `fechaRegistro` date DEFAULT NULL,
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
  `idEditorial` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_books_editoriales1_idx` (`idEditorial`),
  CONSTRAINT `fk_books_editoriales1` FOREIGN KEY (`idEditorial`) REFERENCES `editoriales` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `solicitudes`;
CREATE TABLE `solicitudes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `comentarios` text,
  `idBook` int NOT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_usuario_UNIQUE` (`idBook`,`idUsuario`),
  KEY `fk_solicitudes_books1_idx` (`idBook`),
  KEY `fk_solicitudes_usuarios1_idx` (`idUsuario`),
  CONSTRAINT `fk_solicitudes_usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_solicitudes_books1` FOREIGN KEY (`idBook`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `usuario_perfil`;
CREATE TABLE `usuario_perfil` (
  `idUsuario` int NOT NULL,
  `idPerfil` int NOT NULL,
  UNIQUE KEY `usuario_perfil_UNIQUE` (`idUsuario`,`idPerfil`),
  KEY `fk_usuarios1_idx` (`idUsuario`),
  KEY `fk_perfiles1_idx` (`idPerfil`),
  CONSTRAINT `fk_usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_perfiles1` FOREIGN KEY (`idPerfil`) REFERENCES `perfiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
