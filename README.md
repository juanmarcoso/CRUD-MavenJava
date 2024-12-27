# Proyecto de Gestión de Estudiantes

## Descripción

Este proyecto es una aplicación de gestión de estudiantes desarrollada con Java y Maven. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos de estudiantes.
Tecnologías Utilizadas

```sh
    Java 22.0.2
    Maven 3.8.7
    MySQL 8.4.3
    JDBC 8.4
```

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

```sh
    juan.dominio: Paquete que contiene la clase Estudiante, que representa un estudiante con sus atributos.
    juan.datos: Paquete que contiene la clase EstudianteDAO, que maneja el acceso a datos de la base de datos.
    juan.conexion: Paquete que contiene la clase Conexion, que maneja la conexión a la base de datos.
    pom.xml: Archivo de configuración de Maven.
```

## Funcionalidades

    Crear un nuevo estudiante
    Leer un estudiante por su ID
    Actualizar un estudiante existente
    Eliminar un estudiante por su ID
    Listar todos los estudiantes

## Configuración de la Base de Datos

La configuración de la base de datos se encuentra en el archivo pom.xml. Se utiliza el conector JDBC de MySQL para conectarse a la base de datos.

## Compilación y Ejecución

Para compilar y ejecutar el proyecto, es necesario tener instalado Maven y Java. Luego, ejecutar los siguientes comandos:

```sh
Bash

mvn clean package
mvn exec:java -Dexec.mainClass="juan.Main"
```

## Autor

   Juan Marcos Orellana

### Licencia

Este proyecto está licenciado bajo la licencia [MIT](https://es.wikipedia.org/wiki/Licencia_MIT).
