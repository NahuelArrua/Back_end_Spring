package com.example.Login.service

import com.example.Login.controller.dto.LoginRequest
import com.example.Login.model.User
import org.springframework.stereotype.Service


@Service
interface UserService {

    fun registerUser(user: User): User
    fun loginUser(loginRequest: LoginRequest): User?
    fun findAllUser(): List<User>
    fun findByIdUser(id: Long): User?
    fun upDateUser(id: Long, user: User): User?
    fun deleteUser(id: Long)
}