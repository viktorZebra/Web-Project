package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.model.*
import com.github.viktorzebra.webforum.model.entity.ForumUsersEntity
import com.github.viktorzebra.webforum.model.entity.UserEntity
import com.github.viktorzebra.webforum.model.mapper.ForumUsersMapper
import com.github.viktorzebra.webforum.model.mapper.UserMapper
import com.github.viktorzebra.webforum.repository.ForumUsersRepository
import com.github.viktorzebra.webforum.repository.ForumsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ForumUsersService @Autowired constructor(val forumUsersRepository: ForumUsersRepository,
                                               val userService: UserService,
                                               val forumService: ForumService,
                                               val convert: UserMapper) {

    fun save(authorId: Int, forumId: Int) {
        if (isUserInForumExists(authorId, forumId)) {
            forumUsersRepository.save(ForumUsersEntity(user_id = authorId, forum_id = forumId))
        }
    }

    fun isUserInForumExists(userId: Int, forumId: Int): Boolean {
        return forumUsersRepository.isUserInForumExists(userId, forumId) == 0
    }

    fun getUsersByForum(forumId: Int): List<User?> {
        return forumUsersRepository.getUsersByForum(forumId)
                .filterNotNull()
                .map { convert.convertEntityToModel(it) }
    }
}