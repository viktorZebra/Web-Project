package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.UserAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository){

    fun getUserByNickname(nick: String): UserModel {
        return userRepository.getUserByNickname(nick)  ?: throw UserNotFoundException("Can't find user")
    }

    fun create(user: UserModel){
        if(!checkUserInDB(user))
            userRepository.save(user)
    }

    fun updateProfile(user: UserModel, nickname: String) {
        val currentUser = getUserByNickname(nickname) // проверяем существует ли данный профиль с nickname, чтобы изменить данные

        // проверяем конфликт уже существующего профиля с эмэйлом
        if(!checkUserInDB(user)){
            currentUser.fullname = user.fullname
            currentUser.about = user.about
            currentUser.email = user.email
            userRepository.save(currentUser)
        }
    }

    private fun checkUserInDB(user: UserModel): Boolean{
        val checkUserByEmail = userRepository.getUserByEmail(user.email)

        if(checkUserByEmail == null)
            return false
        else
            throw UserAlreadyCreatedException(checkUserByEmail)
    }

}