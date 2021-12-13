package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ThreadAlreadyCreatedException
import com.github.viktorzebra.webforum.model.PostsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.repository.PostsRepository
import com.github.viktorzebra.webforum.repository.ThreadsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(val postRepository: PostsRepository, val threadService: ThreadsService,
                                         val userService: UserService, val forumUserService: ForumUsersService) {

    fun createPost(post: PostsModel) {
        if (userService.isUserWithNicknameExists(post.author) && threadService.isThreadExists(post.thread)) {
            post.forum = threadService.getThreadById(post.thread).forum

            forumUserService.save(post.author, post.forum)
            postRepository.save(post)
        }
    }
}