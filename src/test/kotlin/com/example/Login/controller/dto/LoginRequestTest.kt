package com.example.Login.controller.dto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class LoginRequestTest {

    @Test

    fun `fun class LoginRequest must initialized correctly`() {

        val loginRequest = LoginRequest(name = "Jorge", password = "passSegura")

        assertEquals(loginRequest.name, "Jorge")
        assertEquals(loginRequest.password, "passSegura")
    }
}