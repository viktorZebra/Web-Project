package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.model.ForumUsersModel
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.repository.ForumUsersRepository
import com.github.viktorzebra.webforum.repository.ForumsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ForumUsersService @Autowired constructor(val forumUsersRepository: ForumUsersRepository,
                                               val userService: UserService, val forumService: ForumService) {

    fun save(authorId: Int, forumId: Int) {
        if (isUserInForumExists(authorId, forumId)) {
            forumUsersRepository.save(ForumUsersModel(user_id = authorId, forum_id = forumId))
        }
    }

    fun isUserInForumExists(userId: Int, forumId: Int): Boolean {
        return forumUsersRepository.isUserInForumExists(userId, forumId) == 0
    }
}