package com.example.Login.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    val id: Long = 0,

    @Column(name = "NOMBRE")
    @field:NotBlank(message = "el campo name no puede estar vacio")
    val name: String,

    @field:NotBlank(message = "el campo apellido no debe estar vacio")
    val apellido: String,

    @field:NotBlank(message = "el campo password no debe estar vacio")
    val password: String
)

/*Data class con todos los datos de registro*/