package com.example.Login.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class UserAlreadyExistsExceptions(message: String) : RuntimeException(message)

//Esta class UserAlreadyExistsExceptions nos muestra un error 409 cuando existe un problema.