package com.example.Login.controller


import com.example.Login.controller.dto.LoginRequest
import com.example.Login.exceptions.UserAlreadyExistsExceptions
import com.example.Login.exceptions.UserNotFoundExceptions
import com.example.Login.model.User
import com.example.Login.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping("/register") // <--- ¡CAMBIA ESTO! La URL efectiva será /api/users/register
    fun registerUser(@Valid @RequestBody user: User): ResponseEntity<User> {
        return try {
            val savedUser = userService.registerUser(user)
            ResponseEntity.status(HttpStatus.CREATED).body(savedUser) // 201 Created
        } catch (e: UserAlreadyExistsExceptions) {
            ResponseEntity.status(HttpStatus.CONFLICT).build() // 409 Conflict
        }
    }

    // Endpoint para el login de usuario
    @PostMapping("/login") // La URL efectiva será /api/users/login
    fun loginUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<User> {
        val user = userService.loginUser(loginRequest)
        return if (user != null) {
            ResponseEntity.ok(user) // 200 OK
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() // 401 Unauthorized
        }
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.findAllUser()
        return ResponseEntity.ok(users) // 200 OK
    }

    // Endpoint para obtener un usuario por ID
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        return try {
            val user = userService.findByIdUser(id)
            ResponseEntity.ok(user) // 200 OK
        } catch (e: UserNotFoundExceptions) {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    // Endpoint para actualizar un usuario por ID
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @Valid @RequestBody user: User): ResponseEntity<User> {
        return try {
            val updatedUser = userService.upDateUser(id, user)
            ResponseEntity.ok(updatedUser) // 200 OK
        } catch (e: UserNotFoundExceptions) {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    // Endpoint para eliminar un usuario por ID
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            userService.deleteUser(id)
            ResponseEntity.noContent().build() // 204 No Content
        } catch (e: UserNotFoundExceptions) {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }
}





