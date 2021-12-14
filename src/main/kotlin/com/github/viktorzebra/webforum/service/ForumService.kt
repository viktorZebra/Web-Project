package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.model.Forums
import com.github.viktorzebra.webforum.model.entity.ForumsEntity
import com.github.viktorzebra.webforum.model.mapper.ForumsMapper
import com.github.viktorzebra.webforum.repository.ForumsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ForumService @Autowired constructor(val forumRepository: ForumsRepository,
                                          val userService: UserService,
                                          val convert: ForumsMapper) {

    fun getForumBySlug(slug: String): Forums {
        val forums: ForumsEntity? = forumRepository.getForumBySlug(slug)
        if (forums != null) {
            return forums.let { convert.convertEntityToModel(it) }
        }
        else{
            throw ForumNotFoundException("Can't find forum by slug")
        }
    }

    fun getForumById(id: String): Forums {
        val forums: ForumsEntity? = forumRepository.getForumById(id.toInt())
        if (forums != null) {
            return forums.let { convert.convertEntityToModel(it) }
        }
        else{
            throw ForumNotFoundException("Can't find forum by id")
        }
    }

    fun create(forum: Forums) {
        checkForumExists(forum.slug)
        userService.getUserById(forum.author_id.toString())

        forumRepository.save(forum.let { convert.convertModelToEntity(it) })
    }

    private fun checkForumExists(forumName: String) {
        val existedForum = forumRepository.getForumBySlug(forumName)

        if (existedForum != null)
             throw ForumAlreadyCreatedException(existedForum)
    }
}

