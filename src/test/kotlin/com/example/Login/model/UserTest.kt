package com.example.Login.model


import kotlin.test.Test
import kotlin.test.assertEquals

class UserTest {

    @Test

    fun ` The class UserTest must initialized correctly `() {


        val user = User(id = 0, name = "Jorge", apellido = "Perez", password = "passSegura")

        assertEquals(user.id, 0)
        assertEquals(user.name, "Jorge")
        assertEquals(user.apellido, "Perez")
        assertEquals(user.password, "passSegura")
    }
}