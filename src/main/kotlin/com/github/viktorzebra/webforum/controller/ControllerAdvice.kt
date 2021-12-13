package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.exception.*
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
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

    @ExceptionHandler(UserAlreadyCreatedException::class)
    fun userAlreadyCreatedException(e: UserAlreadyCreatedException): ResponseEntity<UserModel> {
        return ResponseEntity<UserModel>(e.userModel, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(ForumAlreadyCreatedException::class)
    fun forumAlreadyCreatedException(e: ForumAlreadyCreatedException): ResponseEntity<ForumsModel> {
        return ResponseEntity<ForumsModel>(e.forumsModel, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(ForumNotFoundException::class)
    fun forumNotFoundException(e: ForumNotFoundException): ResponseEntity<Response> {
        val response = Response(e.message)
        return ResponseEntity<Response>(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ThreadAlreadyCreatedException::class)
    fun threadAlreadyCreatedException(e: ThreadAlreadyCreatedException): ResponseEntity<ThreadsModel> {
        return ResponseEntity<ThreadsModel>(e.existedThread, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(ThreadNotFoundException::class)
    fun threadNotFoundException(e: ThreadNotFoundException): ResponseEntity<Response> {
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