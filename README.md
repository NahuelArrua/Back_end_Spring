# Back_end_Spring

Markdown

# 🚀 Back_end_Spring

## 🎯 Tabla de contenido

* [Acerca de](#acerca-de)
* [Características](#caracteristicas)
* [Tecnologías Utilizadas](#tecnologias-utilizadas)
* [Endpoints de la API](#endpoints-de-la-api)
* [Configuración e Instalación](#configuracion-e-instalacion)
* [Uso](#uso)
* [Contribuciones](#contribuciones)
* [Licencia](#licencia)
* [Contacto](#contacto)

---

## 🚀 Acerca de

Este proyecto presenta una **API RESTful de autenticación y gestión de usuarios** robusta y segura, construida con **Spring Boot**. Diseñada para ofrecer una capa de seguridad fundamental a tus aplicaciones, esta solución maneja eficientemente el ciclo de vida de los usuarios, desde el registro y el inicio de sesión hasta la gestión de sus datos, todo ello respaldado por las mejores prácticas de seguridad.

La implementación se basa en un enfoque moderno, utilizando **JSON Web Tokens (JWT)** para la gestión de sesiones sin estado, lo que garantiza escalabilidad y eficiencia. Para la protección de credenciales, las contraseñas de los usuarios se almacenan de forma segura utilizando el algoritmo de hashing **BCryptPasswordEncoder**, previniendo ataques comunes como el "rainbow table".

La persistencia de datos se gestiona a través de **Spring Data JPA**, facilitando la interacción con la base de datos (configurada para H2 en memoria por defecto para un inicio rápido, fácilmente adaptable a PostgreSQL, MySQL, u otras bases de datos relacionales). El código, escrito en **Kotlin**, es limpio, modular y fácil de entender, lo que facilita su integración y mantenimiento en cualquier proyecto que requiera una autenticación fiable.

---

## ✨ Características

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

## 🛠️ Tecnologías Utilizadas

* **Spring Boot:** Framework para el desarrollo rápido de aplicaciones Java/Kotlin.
* **Kotlin:** Lenguaje de programación moderno y conciso.
* **Spring Security:** Framework robusto para autenticación y autorización.
* **Spring Data JPA:** Simplifica la implementación de repositorios de acceso a datos.
* **Hibernate:** Implementación de JPA para ORM (Object-Relational Mapping).
* **JSON Web Tokens (JWT):** Estándar para la creación de tokens de acceso seguro.
* **jJWT:** Librería para la implementación de JWT en Java/Kotlin.
* **BCryptPasswordEncoder:** Implementación de hashing de contraseñas.
* **H2 Database:** Base de datos en memoria para desarrollo y pruebas (configurable para producción).
* **Maven:** Herramienta de gestión de dependencias y construcción de proyectos.

---

## 🚀 Endpoints de la API

A continuación se detallan los principales endpoints disponibles en esta API de autenticación:

| Método | Endpoint                    | Descripción                                      | Autenticación Requerida |
| :----- | :-------------------------- | :----------------------------------------------- | :---------------------- |
| `POST` | `/api/users/register`       | Registra un nuevo usuario en el sistema.         | No                      |
| `POST` | `/api/users/login`          | Autentica un usuario y devuelve un JWT.          | No                      |
| `GET`  | `/api/users`                | Obtiene la lista de todos los usuarios.          | Sí (con JWT)            |
| `GET`  | `/api/users/{id}`           | Obtiene un usuario específico por su ID.         | Sí (con JWT)            |
| `PUT`  | `/api/users/{id}`           | Actualiza la información de un usuario existente. | Sí (con JWT)            |
| `DELETE` | `/api/users/{id}`         | Elimina un usuario por su ID.                    | Sí (con JWT)            |

---

## ⚙️ Configuración e Instalación

Para levantar el proyecto en tu entorno local, sigue los siguientes pasos:

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/Back_end_Spring.git](https://github.com/tu-usuario/Back_end_Spring.git)
    cd Back_end_Spring
    ```

2.  **Configuración de la Base de Datos (Opcional - por defecto usa H2 en memoria):**
    Si deseas utilizar otra base de datos (ej. PostgreSQL), actualiza el archivo `src/main/resources/application.properties` con tus credenciales y configuración:
    ```properties
    # Ejemplo para PostgreSQL
    # spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    # spring.datasource.username=your_user
    # spring.datasource.password=your_password
    # spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Compilar y Ejecutar:**
    Puedes ejecutar el proyecto utilizando Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
    O directamente desde tu IDE (IntelliJ IDEA, VS Code con extensiones de Spring Boot) ejecutando la clase principal `BackEndSpringApplication`.

    El servidor se iniciará por defecto en `http://localhost:8080`.

---

## 💡 Uso

Una vez que el servidor esté en ejecución, puedes interactuar con la API utilizando herramientas como Postman, Insomnia o `curl`.

**Ejemplos Básicos:**

1.  **Registro de un nuevo usuario:**
    ```http
    POST http://localhost:8080/api/users/register
    Content-Type: application/json

    {
        "name": "john.doe",
        "apellido": "Doe",
        "password": "mySecurePassword123"
    }
    ```

2.  **Inicio de Sesión y Obtención de JWT:**
    ```http
    POST http://localhost:8080/api/users/login
    Content-Type: application/json

    {
        "name": "john.doe",
        "password": "mySecurePassword123"
    }
    ```
    *Respuesta exitosa:*
    ```json
    {
        "jwt": "eyJhbGciOiJIUzI1NiIsInR5cCI..." // Tu JWT
    }
    ```

3.  **Acceso a un endpoint protegido (ej. obtener todos los usuarios):**
    Asegúrate de incluir el JWT obtenido en el paso anterior en el encabezado `Authorization` como un `Bearer Token`.
    ```http
    GET http://localhost:8080/api/users
    Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI... // Pega tu JWT aquí
    ```

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras un error, tienes una sugerencia de mejora o quieres añadir una nueva característica, por favor:

1.  Haz un "fork" del repositorio.
2.  Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3.  Realiza tus cambios y escribe pruebas si es posible.
4.  Haz un "commit" de tus cambios (`git commit -m 'feat: Añadir nueva característica X'`).
5.  Haz un "push" a la rama (`git push origin feature/nueva-caracteristica`).
6.  Abre un "Pull Request" describiendo tus cambios.

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

## 📧 Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme:

* **Nahuel Arrua**
* [Tu Perfil de GitHub](https://github.com/Bouaskaoun) (o tu LinkedIn, email, etc.)
* [Tu correo electrónico](mailto:tu.correo@example.com) (opcional)

---

