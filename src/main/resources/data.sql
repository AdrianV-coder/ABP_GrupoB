-- Insertar usuarios
INSERT INTO usuario (nombre, apellidos, correo, contrasena, longitud, latitud)
VALUES('Carlos', 'García', 'carlos@example.com', 'pass123', 40.416775, -3.703790);
INSERT INTO usuario (nombre, apellidos, correo, contrasena, longitud, latitud)
VALUES('María', 'López', 'maria@example.com', 'pass456', 41.385064, 2.173404);
INSERT INTO usuario (nombre, apellidos, correo, contrasena, longitud, latitud)
VALUES('Juan', 'Fernández', 'juan@example.com', 'pass789', 39.469907, -0.376288);
INSERT INTO usuario (nombre, apellidos, correo, contrasena, longitud, latitud)
VALUES('Ana', 'Martínez', 'ana@example.com', 'pass101', 37.774929, -122.419416);
INSERT INTO usuario (nombre, apellidos, correo, contrasena, longitud, latitud)
VALUES('David', 'Ruiz', 'david@example.com', 'pass202', 51.507351, -0.127758);

-- Insertar artículos
INSERT INTO articulo (titulo, descripcion, fecha_creacion, id_usuario)
VALUES('Artículo 1', 'Descripción del artículo 1', CURDATE(), 1);
INSERT INTO articulo (titulo, descripcion, fecha_creacion, id_usuario)
VALUES('Artículo 2', 'Descripción del artículo 2', CURDATE(), 2);
INSERT INTO articulo (titulo, descripcion, fecha_creacion, id_usuario)
VALUES('Artículo 3', 'Descripción del artículo 3', CURDATE(), 3);
INSERT INTO articulo (titulo, descripcion, fecha_creacion, id_usuario)
VALUES('Artículo 4', 'Descripción del artículo 4', CURDATE(), 4);
INSERT INTO articulo (titulo, descripcion, fecha_creacion, id_usuario)
VALUES('Artículo 5', 'Descripción del artículo 5', CURDATE(), 5);