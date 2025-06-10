package com.example.Login.repository

import com.example.Login.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?
    fun findByNameAndPassword(name: String, password: String): User?

}

/* Esta interfaz JpaRepository tendra dos funciones una para encontrar el un nombre y la otra
* funcion es de nombre y password.*/