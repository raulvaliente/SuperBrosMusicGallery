-- Tiendas
INSERT INTO tienda (id, nombre, direccion, telefono) VALUES (1, 'MusicWorld Madrid', 'Calle Gran Vía 45', '911234567');
INSERT INTO tienda (id, nombre, direccion, telefono) VALUES (2, 'SoundStore Barcelona', 'Passeig de Gràcia 12', '932345678');
INSERT INTO tienda (id, nombre, direccion, telefono) VALUES (3, 'Vinyl Planet Sevilla', 'Avenida de la Constitución 8', '954321987');

-- CDs de la tienda 1
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (1, 'Thriller', 'Michael Jackson', 'Pop', 12.99, 1982, 1);
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (2, 'Back in Black', 'AC/DC', 'Rock', 11.50, 1980, 1);
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (3, 'Nevermind', 'Nirvana', 'Grunge', 10.99, 1991, 1);

-- CDs de la tienda 2
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (4, 'Abbey Road', 'The Beatles', 'Rock', 13.50, 1969, 2);
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (5, 'A Night at the Opera', 'Queen', 'Rock', 9.99, 1975, 2);

-- CDs de la tienda 3
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (6, 'El Camino', 'The Black Keys', 'Blues Rock', 8.99, 2011, 3);
INSERT INTO cd (id, titulo, artista, genero, precio, anio, tienda_id) VALUES (7, 'Random Access Memories', 'Daft Punk', 'Electronica', 14.99, 2013, 3)