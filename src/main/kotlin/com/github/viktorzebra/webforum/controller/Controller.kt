package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.service.UserService
import com.github.viktorzebra.webforum.model.UserModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/user")
class UserResource(val userService: UserService){

    @GetMapping("/{nickname}/profile")
    fun getUserProfile(@PathVariable nickname: String): ResponseEntity<UserModel>{
        val user = userService.getUserByNickname(nickname) ?: throw UserNotFoundException("Can't find user")

        return ResponseEntity(user, HttpStatus.OK)
    }


    @PostMapping("/create")
    fun createNewUser(@RequestBody user: UserModel): ResponseEntity<UserModel?>?{
        return try {
            user.id = userService.create(user)
            ResponseEntity(user, HttpStatus.CREATED)
        } catch (e: Exception){
            ResponseEntity(user, HttpStatus.CONFLICT)
        }
    }
}