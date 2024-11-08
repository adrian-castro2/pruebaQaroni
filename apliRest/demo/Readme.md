# Proyecto de Aplicación Spring Boot

## Descripción

Esta aplicación es un servicio RESTful desarrollado con Spring Boot que permite registrar usuarios y enviar correos electrónicos de bienvenida utilizando JavaMailSender. La aplicación incluye autenticación y autorización mediante Spring Security, y permite la exportación de datos a Excel.

## Características

- Registro de usuarios
- Envío de correos electrónicos de bienvenida
- Autenticación y autorización con Spring Security
- Exportación de datos a Excel
- Gestión de autores y libros

## Requisitos

- Java 17 o superior
- Maven 3.6.0 o superior
- PostgreSQL
- Cuenta de Google con verificación en dos pasos habilitada

## Configuración
Para ejecutar la aplicación valdría con ejecutar el siguiente comando
docker-compose up --build

En el servicio de Usuario para evitar estar mandando correos a todo el mundo añadí una clausula if para que solo la mande al correo creado de prueba, en caso de que se quiera comprobar que funciona con otro vale con sacar el if o añadirle al if el correo que se quiera comprobar

Para comprobar que la aplicación funciona de forma correcta recomiendo usar Postman, para ello se dispone de un archivo llamado Qaroni.postman_collection.json que contiene todos las peticiones para comprobar que la API funcione


### Dependencias

Asegúrate de tener las siguientes dependencias en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.3</version>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
