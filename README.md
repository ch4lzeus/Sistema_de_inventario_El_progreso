# 🏪 Sistema de Inventario - Minimarket El Progreso

Sistema de escritorio en Java para gestión de inventario y control de ventas de un minimarket.

## 🚀 Tecnologías

- Java 17
- NetBeans 25
- MySQL 8.0
- Maven
- iText (PDF), JCalendar, MySQL Connector

## 📦 Requisitos

- JDK 17
- MySQL Server 8.0
- Windows 10/11

## ⚙️ Instalación

### 1. Clonar repositorio
```bash
git clone https://github.com/ch4lzeus/Sistema_de_inventario_El_progreso.git
```

### 2. Crear base de datos
```bash
mysql -u root -p < database/Invetario2.sql
```

### 3. Configurar conexión
Editar `src/main/java/modelo/Conexion.java` con tus credenciales MySQL.

### 4. Compilar
```bash
mvn clean package
```

### 5. Ejecutar
```bash
cd target
Ejecutar_Minimarket.bat
```

## 👤 Usuario por defecto

- Usuario: `admin`
- Contraseña: `admin123`

(Crear manualmente en la BD después del script)

## 📊 Funcionalidades

- Gestión de productos, categorías y proveedores
- Registro de entradas (compras) y salidas (ventas)
- Control automático de stock
- Generación de reportes PDF
- Sistema de usuarios con roles

## 🏗️ Arquitectura

- Patrón MVC + DAO
- 8 tablas relacionales
- Interfaz gráfica con Java Swing
