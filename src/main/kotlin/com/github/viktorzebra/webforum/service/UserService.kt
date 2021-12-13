package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.UserAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.entity.UserEntity
import com.github.viktorzebra.webforum.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository){

    fun getUserByNickname(nick: String): UserEntity {
        return userRepository.getUserByNickname(nick) ?: throw UserNotFoundException("Can't find user by nickname")
    }

    fun getUserByEmail(email: String): UserEntity {
        return userRepository.getUserByEmail(email) ?: throw UserNotFoundException("Can't find user by email")
    }

    fun isUserWithEmailExists(email: String): Int {
        return userRepository.isUserWithEmailExists(email)
    }

    fun isUserWithNicknameExists(nick: String): Boolean {
        if (userRepository.getCountUsersByNickname(nick) != 0)
            return true
        else
            throw UserNotFoundException("Can't find user")
    }

    fun create(user: UserEntity) {
        checkUserExists(user.email, user.nickname!!)
        userRepository.save(user)
    }

    fun updateProfile(newUser: UserEntity, nickname: String) {
        val currentUser = getUserByNickname(nickname)
        val userWithEmailForReplace = userRepository.getUserByEmail(newUser.email)

        if (userWithEmailForReplace == null || currentUser.email == newUser.email) {
            currentUser.fullname = newUser.fullname
            currentUser.about = newUser.about
            currentUser.email = newUser.email

            userRepository.save(currentUser)

        } else {
            throw UserAlreadyCreatedException(userWithEmailForReplace)
        }
    }

    private fun checkUserExists(email: String, nickname: String) {
        val existedUserByEmail = userRepository.getUserByEmail(email)
        val existedUserByNickname = userRepository.getUserByNickname(nickname)

        if (existedUserByEmail != null)
            throw UserAlreadyCreatedException(existedUserByEmail)

        if (existedUserByNickname != null)
            throw UserAlreadyCreatedException(existedUserByNickname)
    }
}