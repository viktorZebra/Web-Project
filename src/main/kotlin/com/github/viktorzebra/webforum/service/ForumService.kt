package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.repository.ForumsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ForumService @Autowired constructor(val forumRepository: ForumsRepository, val userService: UserService) {

    fun getForumBySlug(slug: String): ForumsModel {
        return forumRepository.getForumBySlug(slug) ?: throw ForumNotFoundException("Can't find forum by slug")
    }

    fun create(forum: ForumsModel) {
        checkForumExists(forum.slug)

        if (userService.isUserWithNicknameExists(forum.user_nickname))
            forumRepository.save(forum)
    }

    private fun checkForumExists(forumName: String) {
        val existedForum = forumRepository.getForumBySlug(forumName)

        if (existedForum != null)
             throw ForumAlreadyCreatedException(existedForum)
    }

    fun isForumExists(slug: String): Boolean {
        if (forumRepository.getCountForum(slug) != 0)
            return true
        else
            throw ForumNotFoundException("Can't find forum")
    }
}

