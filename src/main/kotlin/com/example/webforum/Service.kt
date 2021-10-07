package com.example.webforum

import io.github.serpro69.kfaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.io.File


@Service
class UserService(val userRepository: UserRepository){

    fun getUserByNickname(nick: String): User?{
        return userRepository.getUserByNickname(nick)
    }
    fun findUser(): List<User>{
        return userRepository.selectAll()
    }

    fun create(user: User): Int?{
        return userRepository.save(user).id
    }
}