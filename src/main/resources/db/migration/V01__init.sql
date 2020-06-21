DROP TABLE IF EXISTS `Perfiles`;
CREATE TABLE `Perfiles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `perfil` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `Usuarios`;
CREATE TABLE `Usuarios` (
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


DROP TABLE IF EXISTS `UsuarioPerfil`;
CREATE TABLE `UsuarioPerfil` (
  `idUsuario` int NOT NULL,
  `idPerfil` int NOT NULL,
  UNIQUE KEY `Usuario_Perfil_UNIQUE` (`idUsuario`,`idPerfil`),
  KEY `fk_Usuarios1_idx` (`idUsuario`),
  KEY `fk_Perfiles1_idx` (`idPerfil`),
  CONSTRAINT `fk_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuarios` (`id`),
  CONSTRAINT `fk_Perfiles1` FOREIGN KEY (`idPerfil`) REFERENCES `Perfiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- db_proyecto.book definition


-- db_proyecto.editorial definition

CREATE TABLE `editorial` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `book` (
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
  `editorial_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg31fjtjyhdp3u9v134xn4ntiq` (`editorial_id`),
  CONSTRAINT `FKg31fjtjyhdp3u9v134xn4ntiq` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;