package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.UserAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.repository.ForumsRepository
import com.github.viktorzebra.webforum.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class ForumService(val forumRepository: ForumsRepository) {

    fun create(forum: ForumsModel) {
        try {
            forumRepository.save(forum)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}