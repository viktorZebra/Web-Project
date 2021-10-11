package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository){

    fun getUserByNickname(nick: String): UserModel? {
        return userRepository.getUserByNickname(nick) ?: throw UserNotFoundException()
    }
    fun findUser(): List<UserModel>{
        return userRepository.selectAll()
    }

    fun create(user: UserModel): Int?{
        return userRepository.save(user).id
    }
}