package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.exception.ThreadAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.UserNotFoundException
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.repository.ForumsRepository
import com.github.viktorzebra.webforum.repository.ThreadsRepository
import com.github.viktorzebra.webforum.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class ForumService(val forumRepository: ForumsRepository, val userRepository: UserRepository,
                   val threadRepository: ThreadsRepository) {

    fun getForumBySlug(slug: String): ForumsModel {
        return forumRepository.getForumBySlug(slug) ?: throw ForumNotFoundException("Can't find forum by slug")
    }

    fun create(forum: ForumsModel) {
        checkForumExists(forum.slug)

        if (isUserExists(forum.user_nickname))
            forumRepository.save(forum)
    }

    fun isUserExists(nick: String): Boolean {
        if (userRepository.getCountUsersByNickname(nick) != 0)
            return true
        else
            throw UserNotFoundException("Can't find user")
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

    fun checkThreadExists(slug: String) {
        val existedThread = threadRepository.getThreadBySlug(slug)

        if (existedThread != null)
            throw ThreadAlreadyCreatedException(existedThread)
    }

    fun createThread(thread: ThreadsModel) {
        isUserExists(thread.author)
        isForumExists(thread.forum!!)
        checkThreadExists(thread.slug)
        threadRepository.save(thread)
    }
}