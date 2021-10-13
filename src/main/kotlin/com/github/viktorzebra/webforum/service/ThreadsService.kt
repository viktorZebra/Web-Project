package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ThreadAlreadyCreatedException
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.repository.ThreadsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ThreadsService @Autowired constructor(val threadRepository: ThreadsRepository,
                                            val userService: UserService, val forumService: ForumService) {

    fun checkThreadExists(slug: String) {
        val existedThread = threadRepository.getThreadBySlug(slug)

        if (existedThread != null)
            throw ThreadAlreadyCreatedException(existedThread)
    }

    fun createThread(thread: ThreadsModel) {
        userService.isUserWithNicknameExists(thread.author)
        forumService.isForumExists(thread.forum)
        checkThreadExists(thread.slug)
        threadRepository.save(thread)
    }
}