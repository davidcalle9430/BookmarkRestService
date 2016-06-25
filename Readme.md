# Impordisa - Sidic

Aplicación web creada usando Spring Boot, Jasper Reports, HTML5, CSS3 y Javascript.

# Dependencias de Ejecución

* Java 8
* MySQL 5.7

# Dependencias de Desarrollador

* [Spring Tool Suite](https://spring.io/tools), IDE basado en ecplise que viene con todas las herramientas necesarias para trabajar con Spring.
* Git

# ¿ Cómo ejecutar la aplicación ?

Si se usa Spring Tool Suite la aplicación se puede ejecutar como cualquier aplicación Java. Sin embargo, en caso de no usarlo se puede ejecutar utilizando el archivo mvnw.

```sh
$  ./mvnw spring-boot:run
```

Para generar el jar. El archivo compilado queda almacenado en la carpeta target. Para más información ver [Documentación](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)

```sh
$  ./mvnw package
```

Para ejecutar el archivo jar

```sh
$  java -jar {NOMBRE_DEL_JAR}
```

#Explicación General de la Arquitectura

//TODO


# Explicación del código

El programa se divide en dos partes principaples, el backend y el frontend.

* Frontend se encuentra en la carpeta src/main/resources
* Backend se encuentra en la carpeta src/main/java

## Backend

La carpeta se divide en diferentes paquetes, cada uno de estos tiene una responsabilidad diferente

### com.impordisa

En este paquete se encuentra el archivo de que ejecuta y configura la aplicación. Estre sus responsabilidades está la creación de los filtros de seguridad personalizados basado en el nombre del menú y el inicio de sesión. 

### conveterts

Este paquete hace referencia a classes encargadas de hacer una conversión de un tipo de dato complejo a una cadena. Por ejemplo si la llave primaria de un usuario es la cédula y el correo, se crea una representación de esa llave como una cadena como {cedula}--{correo}. Para más información ver la documentación de Spring sobre [Converters Sección 2.4.1](http://docs.spring.io/spring-data/rest/docs/1.1.x/reference/html/install-chapter.html)

### projections

Este paquete contiene interfaces que permiten extender el funcionamiento de [Spring Data Rest](http://projects.spring.io/spring-data-rest/) con el fin de crear proyecciones con relaciones más complejas.

### repositories

Este paquete contiene las interfaces de la capa de acceso a datos utilizando el patrón repositorio.

### restcontrollers

Este paquete contiene las clases que exponen la lógica del negocio a las vistas que lo consumen por medio AJAX.

### resultclasses

Este paquete contiene clases intermedias que se intercambian durante la interacción entre cliente y servidor. También conocidas como DTO's. Es de vital importancia **NO** cambiarle el nombre a este paquete ya que hay queries que dependen del nombre

### services

Este paquete contiene la lógica de negocio que se quiere reutilizar

### sidic.entities

Este paquete contiene todas las entidades de la aplicación. Durante el proceso de migración se logró eliminar la mayoría. Sin embargo, todavía es posible que existan unas que no sirvan.

### utility

Este paquete contiene clases estáticas con métodos de utilidad

### web

Este paquete contiene los controladores web de la aplicación; en este caso los controladores se limitan a enrutar al template adecuado y no acceden a la lógica de negocio.

## Frontend

Esta carpeta contiene los archivos estáticos de la aplicación

###  SQL

El archivo contiene un script que debe ser ejecutado para que la base de datos funcione correctamente.

### static

Esta carpeta contiene todos los archivos CSS y javascript de la aplicación. Todo archivo ingresado a esta carpeta, podrá ser accedido por el usuario en la ruta /static/*

### templates

Esta carpeta contiene los archivos HTML a los cuales enruta el paquete web. Los templates son hechos usando [Thymeleaf](http://www.thymeleaf.org/)

### views

Esta carpeta contiene los archivos html estáticos


### application.properties

Archivo que contiene configuración global de la aplicación, como el puerto y el formato de las fechas

