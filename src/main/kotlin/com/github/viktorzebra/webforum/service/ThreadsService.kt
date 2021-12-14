package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ThreadAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ThreadNotFoundException
import com.github.viktorzebra.webforum.exception.UserAlreadyCreatedException
import com.github.viktorzebra.webforum.model.Threads
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.model.entity.ThreadsEntity
import com.github.viktorzebra.webforum.model.mapper.ThreadsMapper
import com.github.viktorzebra.webforum.repository.ThreadsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ThreadsService @Autowired constructor(val threadRepository: ThreadsRepository,
                                            val userService: UserService,
                                            val forumService: ForumService,
                                            val forumUserService: ForumUsersService,
                                            val convert: ThreadsMapper) {

    fun checkThreadExists(slug: String) {
        val existedThread = threadRepository.getThreadBySlug(slug)

        if (existedThread != null)
            throw ThreadAlreadyCreatedException(existedThread)
    }

    fun updateThread(newThread: Threads, id: String) {
        val existsThread = threadRepository.getThreadBySlug(newThread.slug)

        if (existsThread == null || existsThread.id == id.toInt()) {
            newThread.id = id.toInt()
            threadRepository.save(newThread.let { convert.convertModelToEntity(it) })
        } else {
            throw ThreadAlreadyCreatedException(existsThread)
        }
    }

    fun isThreadExists(id: Int): Boolean {
        if (threadRepository.isThreadExistsById(id) != 0) {
            return true

        } else {
            throw ThreadNotFoundException("Can't find thread by id")
        }
    }

    fun getThreadById(id: Int): Threads {
        val thread: ThreadsEntity? = threadRepository.getThreadById(id)
        if (thread != null) {
            return thread.let { convert.convertEntityToModel(it) }
        }
        else{
            throw throw ThreadNotFoundException("Can't find thread by id")
        }
    }

    fun createThread(thread: Threads) {
        userService.getUserById(thread.author_id.toString())
        forumService.getForumById(thread.forum_id.toString())

        checkThreadExists(thread.slug)

        forumUserService.save(thread.author_id, thread.forum_id)
        threadRepository.save(thread.let { convert.convertModelToEntity(it) })
    }

    fun getThreadByForum(id: Int): List<Threads?> {
        forumService.getForumById(id.toString())

        return threadRepository.getThreadByForum(id)
            .filterNotNull()
            .map { convert.convertEntityToModel(it) }
    }
}