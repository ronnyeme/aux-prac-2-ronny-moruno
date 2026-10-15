
# API REST - Gestión de Biblioteca

## Práctica #2 - Tecnologías Emergentes

**Universidad:** Universidad Autónoma Tomás Frías  
**Carrera:** Ingeniería de Sistemas  
**Estudiante:** Ronny Moruno  
**Materia:** Tecnologías Emergentes SIS-414 G2

## Descripción

API REST desarrollada con Spring Boot para gestionar
libros mediante operaciones CRUD.

La información se almacena temporalmente en memoria
utilizando ArrayList, sin conexión a una base de datos.

## Tecnologías utilizadas

- Java 26
- Spring Boot 4.1.1
- Gradle
- Spring Web
- Swagger / OpenAPI
- Git y GitHub

## Arquitectura

El proyecto está organizado en cuatro capas:

- Model: representa la entidad Book.
- DTO: recibe y valida los datos.
- Service: contiene la lógica del CRUD.
- Controller: administra las peticiones HTTP.

## Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/books | Registrar libro |
| GET | /api/books | Listar libros |
| GET | /api/books/{id} | Buscar libro |
| PUT | /api/books/{id} | Actualizar libro |
| DELETE | /api/books/{id} | Eliminar libro |

## Códigos HTTP

- 200 OK: consulta o actualización exitosa.
- 201 Created: libro registrado.
- 204 No Content: libro eliminado.
- 400 Bad Request: datos inválidos.
- 404 Not Found: libro inexistente.

## Ejecución

Requisitos:
- JDK 26
- Conexión a Internet para descargar dependencias

Clonar el repositorio:

```bash
git clone https://github.com/USUARIO/aux-prac-2-ronny-moruno.git
```

Ingresar al proyecto:

```bash
cd aux-prac-2-ronny-moruno
```

Ejecutar en Windows:

```powershell
.\gradlew.bat bootRun
```

## Swagger

Con la aplicación ejecutándose, ingresar a:

http://localhost:8080/swagger-ui/index.html

Desde Swagger se pueden probar los cinco endpoints.

## Ejemplo JSON

```json
{
  "title": "El Principito",
  "author": "Antoine de Saint-Exupéry",
  "isbn": "9780156012195",
  "publicationYear": 1943,
  "category": "Literatura",
  "available": true
}
```

## Nota

Los datos se almacenan únicamente en memoria.
Al reiniciar la aplicación se pierde la información.
