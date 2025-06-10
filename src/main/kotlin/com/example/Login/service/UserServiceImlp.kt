package com.example.Login.service

import com.example.Login.controller.dto.LoginRequest
import com.example.Login.exceptions.UserAlreadyExistsExceptions
import com.example.Login.exceptions.UserNotFoundExceptions
import com.example.Login.model.User
import com.example.Login.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImplementation(private val userRepository: UserRepository) : UserService {
    override fun registerUser(user: User): User {
        if (userRepository.findByName(user.name) != null) {
            throw UserAlreadyExistsExceptions(message = "El usuario ${user.name} no se encuentra registrado")
        }
        return userRepository.save(user)
    }

    override fun loginUser(loginRequest: LoginRequest): User? {
        return userRepository.findByNameAndPassword(loginRequest.name, loginRequest.password)
    }

    override fun findAllUser(): List<User> {
        return userRepository.findAll()
    }

    override fun findByIdUser(id: Long): User? {
        return userRepository.findById(id)
            .orElseThrow { UserNotFoundExceptions(message = "El usuario con el ID${id} no se ah encontrado") }
    }

    override fun upDateUser(id: Long, user: User): User? {
        return userRepository.findById(id).map { existingUser ->

            val update = existingUser.copy(
                name = user.name,
                apellido = user.apellido,
                password = user.password
            )
            userRepository.save(update)
        }
            .orElseThrow { UserNotFoundExceptions(message = "El usuario con ID ${id} no se encuentra para ser actualizado") }
    }

    override fun deleteUser(id: Long) {
        if (userRepository.existsById(id)) {
            throw UserNotFoundExceptions(message = "El usuario con el ID${id} no se encuentra para ser eliminado")
        }
    }
}