package com.example.Login.controller.dto

import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank

data class RegisterRequest(

    @Column(name = "NOMBRE")
    @field:NotBlank(message = "el campo name no debe estar vacio")
    val name: String,

    @field:NotBlank(message = "el campo apellido no debe estar vacio")
    val apellido: String,

    @field:NotBlank(message = "el campo no debe estar vacio")
    val password: String
)

/*Datos del registro*/