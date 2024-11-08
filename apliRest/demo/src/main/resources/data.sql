INSERT INTO usuarios (username, correo, contrasena, nombre_completo, role_name) VALUES
('maria.gomez', 'maria.gomez@biblioteca.com', 'password123', 'María Gómez', 'ADMIN'),
('juan.perez', 'juan.perez@biblioteca.com', 'password123', 'Juan Pérez', 'LIBRARIAN'),
('ana.lopez', 'ana.lopez@biblioteca.com', 'password123', 'Ana López', 'LIBRARIAN'),
('carlos.martinez', 'carlos.martinez@biblioteca.com', 'password123', 'Carlos Martínez', 'LIBRARIAN'),
('laura.garcia', 'laura.garcia@biblioteca.com', 'password123', 'Laura García', 'ADMIN'),
('pedro.rodriguez', 'pedro.rodriguez@biblioteca.com', 'password123', 'Pedro Rodríguez', 'LIBRARIAN'),
('userAdmin', 'userAdmin@biblioteca.com', '1234', 'User Admin', 'ADMIN'),
('userLibrarian', 'userLibrarian@biblioteca.com', '1234', 'User Librarian', 'LIBRARIAN');



-- Insertar autores de prueba
INSERT INTO autores (nombre, biografia) VALUES
('Gabriel García Márquez', 'Autor colombiano conocido por su obra "Cien años de soledad".'),
('Isabel Allende', 'Escritora chilena famosa por "La casa de los espíritus".'),
('J.K. Rowling', 'Autora británica de la serie de libros "Harry Potter".'),
('Haruki Murakami', 'Escritor japonés conocido por "Kafka en la orilla".'),
('Miguel de Cervantes', 'Escritor español, autor de El Quijote.');

-- Insertar libros de prueba
INSERT INTO libros (titulo, descripcion, fecha_publicacion) VALUES
('Cien años de soledad', 'Una novela que narra la historia de la familia Buendía en el pueblo ficticio de Macondo.', '1967-05-30'),
('El amor en los tiempos del cólera', 'Una historia de amor que se desarrolla a lo largo de varias décadas.', '1985-09-05'),
('La casa de los espíritus', 'Una saga familiar que mezcla realismo mágico y política.', '1982-10-15'),
('De amor y de sombra', 'Una novela sobre el amor y la resistencia política en Chile.', '1984-05-01'),
('Harry Potter y la piedra filosofal', 'El primer libro de la serie de Harry Potter.', '1997-06-26'),
('Harry Potter y la cámara secreta', 'El segundo libro de la serie de Harry Potter.', '1998-07-02'),
('Harry Potter y el prisionero de Azkaban', 'El tercer libro de la serie de Harry Potter.', '1999-07-08'),
('Harry Potter y el cáliz de fuego', 'El cuarto libro de la serie de Harry Potter.', '2000-07-08'),
('Kafka en la orilla', 'Una novela que mezcla elementos de realismo mágico y surrealismo.', '2002-09-12'),
('Tokio Blues', 'Una historia de amor y pérdida ambientada en Tokio.', '1987-09-04'),
('1Q84', 'Una novela distópica que sigue a dos personajes en un Tokio alternativo.', '2009-05-29'),
('Crónica del pájaro que da cuerda al mundo', 'Una novela que mezcla misterio y realismo mágico.', '1994-04-12'),
('Sputnik, mi amor', 'Una historia de amor y soledad.', '1999-04-20'),
('Los años de peregrinación del chico sin color', 'Una novela sobre la búsqueda de la identidad y el amor.', '2013-04-12'),
('Hombres sin mujeres', 'Una colección de relatos cortos sobre la soledad y las relaciones humanas.', '2014-04-18'),
('El viaje de los héroes', 'Una novela épica sobre el viaje de dos héroes en un mundo fantástico.', '2024-11-08');

-- Relacionar libros con autores
INSERT INTO libros_autores (libro_id, autor_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 3),
(8, 3),
(9, 4),
(10, 4),
(11, 4),
(12, 4),
(13, 4),
(14, 4),
(15, 4),
(16, 1), 
(16, 2); 
