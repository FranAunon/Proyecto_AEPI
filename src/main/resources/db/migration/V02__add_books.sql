INSERT INTO db_proyecto.editoriales (name,address,version) VALUES 
('Anaya','Madrid',0)
,('Paraninfo','Sevilla',0)
,('Ra-ma','Madrid',0)
,('Planeta','Valencia',0)
;

INSERT INTO db_proyecto.perfiles
(perfil)
VALUES('SUPERVISOR')
,('ADMINISTRADOR')
,('USUARIO');




INSERT INTO db_proyecto.books (isbn,author,descripcion,destacado,imagen,price,published_date,title,version,detalles,id_editorial) VALUES 
('9781234567890','Woody Allen','<p>Woody Allen que durante las seis décadas que lleva haciendo cine ha escrito y dirigido cincuenta películas</p>',1,'978849181995.gif',20.0,'2019-04-09 22:00:00','A proposito de nada',0,NULL,1)
,('9781234567891','Lorenzo Silva','<p>Un varón de mediana edad aparece desnudo y brutalmente asesinado en una solitaria playa de Formentera. </p>',1,'978842335756.gif',10.0,'2019-06-09 22:00:00','El mal de corcira',0,NULL,2)
,('9781234567892','Joel Dicker','<p>NÚMERO 1 EN VENTAS Vuelve el «principito de la literatura negra contemporánea, el niño mimado de la industria literaria» (GQ): el nuevo thriller de Joël Dicker es su novela más personal.</p>',1,'978842043938.gif',15.0,'2020-03-09 22:00:00','El enigma de la habitacion',0,NULL,3)
,('9781234567893','Collins Suzanne','<p>La ambición será su motor.La rivalidad, su motivación.Pero alcanzar el poder tiene un precio.Es la mañana de la cosecha que dará comienzo a los décimos Juegos del Hambre.</p>',1,'978842722028.gif',15.0,'2018-06-09 22:00:00','Los juegos del hambre',0,NULL,2)
,('9781234567894','Irene Vallejo','<p>Premio el Ojo Crítico de Narrativa 2019 Premio Las Librerías Recomiendan de No Ficción 2020 Premio Búho al Mejor Libro de 2019 </p>',1,'978841786079.gif',18.0,'2017-06-09 22:00:00','El infinito en un junco',0,NULL,1)
;


-- Insertamos nuestros usuarios
INSERT INTO `users` VALUES ('luis','{noop}luis123',1);
INSERT INTO `users` VALUES ('marisol','{noop}mari123',1);

-- Insertamos (asignamos roles) a nuestros usuarios.
INSERT INTO `authorities` VALUES ('luis','SUPERVISOR');
INSERT INTO `authorities` VALUES ('marisol','ADMINISTRADOR');

INSERT INTO `usuarios` VALUES (2,'Luis Esparza Gomez','luis@itinajero.net','luis','{noop}luis123',1,'2019-06-10');
INSERT INTO `usuarios` VALUES (3,'Marisol Salinas Rodarte','marisol@itinajero.net','marisol','{noop}mari123',1,'2019-06-10');


INSERT INTO `usuario_perfil` VALUES (2, 1); -- PERFIL SUPERVISOR
INSERT INTO `usuario_perfil` VALUES (3, 2); -- PERFIL ADMINISTRADOR



