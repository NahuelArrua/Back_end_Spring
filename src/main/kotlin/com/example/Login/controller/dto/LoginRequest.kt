package com.example.Login.controller.dto

import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank


data class LoginRequest(

    @Column(name = "NOMBRE")
    @field:NotBlank(message = "el campo no debe estar vacio")
    val name: String,

    @field:NotBlank(message = "el campo no debe estar vacio")
    val password: String
)

/*Datos del login*/