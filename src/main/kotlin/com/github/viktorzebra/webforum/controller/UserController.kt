package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.service.UserService
import com.github.viktorzebra.webforum.model.UserModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/user")
class UserResource(val userService: UserService){

    @GetMapping("/{nickname}/profile")
    fun getUserProfile(@PathVariable nickname: String): ResponseEntity<UserModel>{
        val user = userService.getUserByNickname(nickname)

        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping("/create")
    fun createNewUser(@RequestBody user: UserModel): ResponseEntity<UserModel>{
        userService.create(user)

        return ResponseEntity(user, HttpStatus.CREATED)
    }

    @PutMapping("/{nickname}/profile")
    fun updateUserProfile(@RequestBody user: UserModel, @PathVariable nickname: String): ResponseEntity<UserModel>{
        userService.updateProfile(user, nickname)

        return ResponseEntity(userService.getUserByNickname(nickname), HttpStatus.OK)
    }
}