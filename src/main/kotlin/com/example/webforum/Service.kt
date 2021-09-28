package com.example.webforum

import io.github.serpro69.kfaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.io.File


@Service
class UserService(val db: UserRepository){

    fun findUser(): List<User>{
        return db.selectAll()
    }

    fun post(user: User){
        db.save(user)
    }
}