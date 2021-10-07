package com.example.webforum

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/user")
class UserResource(val userService: UserService){

    @GetMapping("/{nickname}/profile")
    fun getUserProfile(@PathVariable nickname: String): ResponseEntity<Any?>?{
        val user = userService.getUserByNickname(nickname)

        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK)
        } else{
            ResponseEntity("{\n \"message\": \"Can't find user with id #42\" \n}", HttpStatus.NOT_FOUND)
        }
    }


    @PostMapping("/create")
    fun createNewUser(@RequestBody user: User): ResponseEntity<User?>?{
        return try {
            user.id = userService.create(user)
            ResponseEntity(user, HttpStatus.CREATED)
        } catch (e: Exception){
            ResponseEntity(user, HttpStatus.CONFLICT)
        }
    }
}