package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumAlreadyCreatedException
import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.model.ForumUsersModel
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.repository.ForumUsersRepository
import com.github.viktorzebra.webforum.repository.ForumsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ForumUsersService @Autowired constructor(val forumUsersRepository: ForumUsersRepository,
                                               val userService: UserService, val forumService: ForumService) {

    fun save(userName: String, forumSlug: String) {
        val userID = userService.getUserByNickname(userName).id
        val forumID = forumService.getForumBySlug(forumSlug).id

        if (isUserInForumExists(userID, forumID)) {
            forumUsersRepository.save(ForumUsersModel(user_id = userID, forum_id = forumID))
        }
    }

    fun isUserInForumExists(userID: Int, forumID: Int): Boolean {
        return forumUsersRepository.isUserInForumExists(userID, forumID) == 0
    }
}