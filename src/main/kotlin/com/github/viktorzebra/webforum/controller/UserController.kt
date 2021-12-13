package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.service.UserService
import com.github.viktorzebra.webforum.model.UserModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/user")
class UserResource(val userService: UserService){

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): ResponseEntity<UserModel>{
        val user = userService.getUserById(id)

        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody user: UserModel): ResponseEntity<UserModel>{
        userService.create(user)

        return ResponseEntity(user, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateUser(@RequestBody user: UserModel, @PathVariable id: String): ResponseEntity<UserModel>{
        userService.updateProfile(user, id)

        return ResponseEntity(userService.getUserById(id), HttpStatus.OK)
    }
}