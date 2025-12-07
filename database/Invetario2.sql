-- Paso 1: Crear la nueva base de datos
CREATE DATABASE inventario2;

-- Paso 2: Seleccionar la nueva base de datos
USE inventario2;

-- Paso 3: Crear la tabla usuarios con las modificaciones

CREATE TABLE usuarios (
  idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Eliminar el (11)
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  documento VARCHAR(12) NOT NULL,
  direccion VARCHAR(100) NOT NULL,
  telefono VARCHAR(11) NOT NULL,
  tipoUsuario VARCHAR(20) NOT NULL,
  usuario VARCHAR(15) NOT NULL,
  pass VARCHAR(100) NOT NULL  -- Contraseña en texto plano
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Paso 4: Crear la tabla categorias

CREATE TABLE categorias (
  idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Eliminar (11)
  categoria VARCHAR(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Paso 5: Crear la tabla producto

CREATE TABLE productos (
  idproducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Eliminar (11)
  nombre VARCHAR(30) NOT NULL,  -- Nombre del producto
  stock INT NOT NULL,  -- Cantidad en stock
  idCategoria INT NOT NULL,  -- Referencia a la tabla categorias
  precioV DECIMAL(8,2) NOT NULL,  -- Precio de venta del producto
  FOREIGN KEY (idCategoria) REFERENCES categorias(idCategoria)  -- Relación con la tabla categorias
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Paso 6: Crear la tabla proveedor
CREATE TABLE proveedor (
  idproveedor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Eliminar (11)
  nombre VARCHAR(30) NOT NULL,  -- Nombre del proveedor
  apellido VARCHAR(30) NOT NULL,  -- Apellido del proveedor
  documento VARCHAR(12) NOT NULL,  -- Documento de identificación del proveedor
  Rsocial VARCHAR(100) NOT NULL,  -- Razón social del proveedor
  direccion VARCHAR(100) NOT NULL,  -- Dirección del proveedor
  telefono VARCHAR(11) NOT NULL,  -- Teléfono del proveedor
  correo VARCHAR(50) NOT NULL  -- Correo del proveedor
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Paso 7: Crear la tabla entrada
CREATE TABLE entrada (
  identrada INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Eliminar (11)
  idproducto INT NOT NULL,
  stock INT NOT NULL,
  fecha DATE NOT NULL,
  idproveedor INT NOT NULL,
  precioE DECIMAL(10,2) NOT NULL,
  precioV DECIMAL(10,2) NOT NULL,
  total DECIMAL(8,2) NOT NULL,
  FOREIGN KEY (idproducto) REFERENCES productos(idproducto),  -- Referencia a la tabla productos
  FOREIGN KEY (idproveedor) REFERENCES proveedor(idproveedor)  -- Referencia a la tabla proveedor
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Paso 8: Crear la tabla salidas
CREATE TABLE salidas (
  idSalida INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Identificador de la ventaproductos
  numSalida VARCHAR(10) NOT NULL,  -- Número de salida (identificador único de la venta)
  fecha DATE NOT NULL,  -- Fecha de la venta
  subtotal DECIMAL(10,2) NOT NULL,  -- Subtotal de la venta (sin IGV)
  igv DECIMAL(10,2) NOT NULL,  -- IGV calculado
  total DECIMAL(10,2) NOT NULL  -- Total de la venta (subtotal + IGV)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Paso 9: Crear la tabla detallesalida
CREATE TABLE detallesalida (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- Identificador de la línea de detalle
  idSalida INT NOT NULL,  -- Relación con la tabla salidas
  idproducto INT NOT NULL,  -- Relación con el producto vendido
  cantidad INT NOT NULL,  -- Cantidad de productos vendidos
  importe DECIMAL(10,2) NOT NULL,  -- Importe total por producto (cantidad * precio)
  FOREIGN KEY (idSalida) REFERENCES salidas(idSalida),  -- Relación con la tabla salidas
  FOREIGN KEY (idproducto) REFERENCES productos(idproducto)  -- Relación con la tabla productos
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
