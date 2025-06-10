package com.example.Login.exceptions

import org.aspectj.bridge.Message
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundExceptions(message: String) : RuntimeException(message)

// esta class UserNotFoundExceptions nos muestra un error 404 cuando exixte un problema.