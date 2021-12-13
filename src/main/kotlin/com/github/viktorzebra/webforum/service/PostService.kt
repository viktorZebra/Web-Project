package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.ForumNotFoundException
import com.github.viktorzebra.webforum.exception.ThreadAlreadyCreatedException
import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.PostsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.repository.PostsRepository
import com.github.viktorzebra.webforum.repository.ThreadsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(val postRepository: PostsRepository, val threadService: ThreadsService,
                                         val userService: UserService, val forumUserService: ForumUsersService,
                                         val forumService: ForumService) {

    fun createPost(post: PostsModel) {
        userService.getUserById(post.author_id.toString())
        threadService.getThreadById(post.thread_id)
        forumService.getForumById(post.forum_id.toString())

        forumUserService.save(post.author_id, post.forum_id)
        postRepository.save(post)
    }

    fun getPostsByThreadId(id: String): MutableList<PostsModel?> {
        return postRepository.getPostsByThreadId(id.toInt())

    }
}