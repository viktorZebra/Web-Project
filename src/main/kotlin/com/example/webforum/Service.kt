package com.example.webforum

import Exception.UserNotFoundException
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository){

    fun getUserByNickname(nick: String): User? {
        return userRepository.getUserByNickname(nick) ?: throw UserNotFoundException()
    }
    fun findUser(): List<User>{
        return userRepository.selectAll()
    }

    fun create(user: User): Int?{
        return userRepository.save(user).id
    }
}