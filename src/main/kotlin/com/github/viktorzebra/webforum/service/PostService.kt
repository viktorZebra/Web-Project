package com.github.viktorzebra.webforum.service

import com.github.viktorzebra.webforum.exception.PostNotFoundException
import com.github.viktorzebra.webforum.model.Posts
import com.github.viktorzebra.webforum.model.entity.PostsEntity
import com.github.viktorzebra.webforum.model.mapper.PostsMapper
import com.github.viktorzebra.webforum.repository.PostsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(val postRepository: PostsRepository,
                                         val threadService: ThreadsService,
                                         val userService: UserService,
                                         val forumUserService: ForumUsersService,
                                         val forumService: ForumService,
                                         val convert: PostsMapper) {

    fun createPost(post: Posts) {
        userService.getUserById(post.author_id.toString())
        threadService.getThreadById(post.thread_id)
        forumService.getForumById(post.forum_id.toString())

        forumUserService.save(post.author_id, post.forum_id)
        postRepository.save(post.let { convert.convertModelToEntity(it) })
    }

    fun getPostsByThreadId(id: String): List<Posts?> {
        threadService.getThreadById(id.toInt())
        return postRepository.getPostsByThreadId(id.toInt())
               .filterNotNull()
               .map { convert.convertEntityToModel(it) }
    }

    fun getPostById(id: String): Posts {
        val post: PostsEntity? = postRepository.getPostById(id.toInt())
        if (post != null) {
            return post.let { convert.convertEntityToModel(it) }
        }
        else{
            throw PostNotFoundException("Can't find post by id")
        }
    }

    fun updatePost(newPost: Posts, id: String) {
        postRepository.getPostById(id.toInt())

        newPost.id = id.toInt()
        postRepository.save(newPost.let { convert.convertModelToEntity(it) })
    }
}