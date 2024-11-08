
DROP TABLE IF EXISTS usuarios CASCADE;
DROP TABLE IF EXISTS autores CASCADE;
DROP TABLE IF EXISTS libros CASCADE;
DROP TABLE IF EXISTS libros_autores CASCADE;

-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    correo VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(255) NOT NULL,
    role_name VARCHAR(50) NOT NULL CHECK (role_name IN ('ADMIN', 'LIBRARIAN'))
);


-- Crear la tabla de autores
CREATE TABLE autores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    biografia TEXT
);

-- Crear la tabla de libros
CREATE TABLE libros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_publicacion DATE
);

-- Crear la tabla intermedia para la relación muchos a muchos entre libros y autores
-- Crear la tabla de relación libros_autores
CREATE TABLE libros_autores (
    libro_id INTEGER NOT NULL,
    autor_id INTEGER NOT NULL,
    PRIMARY KEY (libro_id, autor_id),
    FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE,
    FOREIGN KEY (autor_id) REFERENCES autores(id) ON DELETE CASCADE
);
