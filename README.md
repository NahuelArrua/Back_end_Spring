
#  Back_end_Spring

##  Tabla de contenido



  - [Acerca de](#acerca-de)
  - [Caracteristicas](#caracteristicas)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
 



# Acerca de
Este proyecto presenta una **API RESTful de autenticación y gestión de usuarios** robusta y segura, construida con **Spring Boot**. Diseñada para ofrecer una capa de seguridad fundamental a tus aplicaciones, esta solución maneja eficientemente el ciclo de vida de los usuarios, desde el registro y el inicio de sesión hasta la gestión de sus datos, todo ello respaldado por las mejores prácticas de seguridad.

La implementación se basa en un enfoque moderno, utilizando **JSON Web Tokens (JWT)** para la gestión de sesiones sin estado, lo que garantiza escalabilidad y eficiencia. Para la protección de credenciales, las contraseñas de los usuarios se almacenan de forma segura utilizando el algoritmo de hashing **BCryptPasswordEncoder**, previniendo ataques comunes como el "rainbow table".

La persistencia de datos se gestiona a través de **Spring Data JPA**, facilitando la interacción con la base de datos (configurada para H2 en memoria por defecto para un inicio rápido, fácilmente adaptable a PostgreSQL, MySQL, u otras bases de datos relacionales). El código, escrito en **Kotlin**, es limpio, modular y fácil de entender, lo que facilita su integración y mantenimiento en cualquier proyecto que requiera una autenticación fiable.

---



# Caracteristicas

* **Registro de Usuarios Seguro:** Permite a los nuevos usuarios crear cuentas con validación de datos y almacenamiento seguro de contraseñas utilizando BCrypt.
* **Inicio de Sesión Basado en JWT:** Autenticación de usuarios mediante nombre de usuario y contraseña, generando un JSON Web Token para la gestión de sesiones sin estado.
* **Protección de Endpoints:** Los endpoints de la API están protegidos, requiriendo autenticación JWT para acceder a recursos sensibles.
* **Gestión de Usuarios (CRUD):**
    * Listar todos los usuarios.
    * Obtener un usuario por ID.
    * Actualizar los datos de un usuario.
    * Eliminar un usuario.
* **Manejo de Excepciones:** Respuestas HTTP claras para errores como usuario no encontrado o usuario ya existente.
* **Configuración de Seguridad Flexible:** Integración con Spring Security para una gestión granular de la seguridad.

---

# Tecnologias Utilizadas

* **Spring Boot:** Framework para el desarrollo rápido de aplicaciones Java/Kotlin.
<img src="Backend.png" alt="logo Spring boot" width="160" heigth="160">

* **Kotlin:** Lenguaje de programación moderno y conciso.
<img src="kotlin.png" alt="logo JpaBuddy" width="160" height="160">

* **Spring Security:** Framework robusto para autenticación y autorización.
* **Spring Data JPA:** Simplifica la implementación de repositorios de acceso a datos.


* **JSON Web Tokens (JWT):** Estándar para la creación de tokens de acceso seguro.
<img src="jwt.png" alt="logo JpaBuddy" width="160" height="160">

* **jJWT:** Librería para la implementación de JWT en Java/Kotlin.
* **BCryptPasswordEncoder:** Implementación de hashing de contraseñas.
* **H2 Database:** Base de datos en memoria para desarrollo y pruebas (configurable para producción).
<img src="jpa buddy.png" alt="logo JpaBuddy" width="160" height="160">


JPA Buddy automatiza muchas tareas repetitivas asociadas con el desarrollo de JPA y Spring Data JPA en Kotlin, como la creación de entidades y repositorios.

<div align="center">
  <h2>Pruebas de api con postman.</h2>
</div>


* Datos de solicitud y respuesta: confirmar que las solicitudes estén formateadas correctamente y que las respuestas contengan los datos precisos y previstos.

* Códigos de estado: verificación de códigos de estado HTTP apropiados ( 200 OK, 404 No encontrado, 500 Error interno del servidor) para garantizar un manejo adecuado de errores y operaciones exitosas.

<div align="center">
  <img src="logo_postman.png" alt="postman logo" width="400" height="600">>
</div>

## API Authentication Tests with Postman

This section details the Postman tests conducted for the user registration and login functionalities of the Spring Boot application's authentication system.

### 1. User Registration (POST /api/users/register)

**Objective:** To verify the successful registration of a new user.

**Method:** A `POST` request was sent to the `/api/users/register` endpoint with a JSON body containing the new user's `name`, `apellido` (last name), and `password`.

**Request Body Example:**

json

{
    "name": "user",
    "apellido": "userLastName",
    "password": "password123!!"
}

Resultado esperado: Un 201 Createdcódigo de estado que indica que el usuario se creó correctamente. Se espera que el cuerpo de la respuesta incluya los datos del usuario registrado, incluyendo una contraseña cifrada (por seguridad).

Resultado real (de la captura de pantalla):

Estado: 201 Created

Tiempo: 99 ms

Tamaño: 469 B

Ejemplo de cuerpo de respuesta:

 <img src="post_login.png" alt="postman logo" width="400" height="600">


JSON

{
    "id": 203,
    "name": "user",
    "apellido": "userLastName",
    "password": "$2a$10$yDBKM5MX6E/upuTD6MeOCoFhJ3GD5HbBUWbFVgNGXKVCi0IiRGe"
}

Conclusión: El punto final de registro de usuario funciona como se esperaba, crea exitosamente nuevas cuentas de usuario y devuelve el estado y los datos de usuario apropiados.







