package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.repository.ForumsRepository
import com.github.viktorzebra.webforum.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class ForumService(val forumRepository: ForumsRepository, val userRepository: UserRepository) {

    fun create(forum: ForumsModel) {
        getUserByNickname(forum.user_nickname)
        checkForumExists(forum.slug)
        forumRepository.save(forum)
    }

    fun getUserByNickname(nick: String): UserModel {
        return userRepository.getUserByNickname(nick) ?: throw UserNotFoundException("Can't find user")
    }

    private fun checkForumExists(forumName: String) {
        val existedForum = forumRepository.getForumBySlug(forumName)
        if (existedForum != null)
             throw ForumAlreadyCreatedException(existedForum)
    }
}