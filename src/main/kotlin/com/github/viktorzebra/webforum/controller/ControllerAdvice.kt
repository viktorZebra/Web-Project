package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.UserModel
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundException(e: UserNotFoundException): ResponseEntity<Response> {

        val response = Response(e.message)
        return ResponseEntity<Response>(response, HttpStatus.NOT_FOUND)
    }
}

class Response {
    var message: String? = null

    constructor(message: String?) {
        this.message = message
    }
}