package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.service.ForumService
import com.github.viktorzebra.webforum.service.ForumUsersService
import com.github.viktorzebra.webforum.service.ThreadsService
import com.github.viktorzebra.webforum.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/forum")
class ForumResource(val forumService: ForumService,
                    val threadService: ThreadsService,
                    val forumUserService: ForumUsersService) {

    @PostMapping
    fun createForum(@RequestBody forum: ForumsModel): ResponseEntity<ForumsModel>{
        forumService.create(forum)

        return ResponseEntity(forum, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getForum(@PathVariable id: String): ResponseEntity<ForumsModel>{
        val forum = forumService.getForumById(id)

        return ResponseEntity(forum, HttpStatus.OK)
    }

    @GetMapping("/{id}/users")
    fun getUsersByForum(@PathVariable id: String): ResponseEntity<MutableList<UserModel?>>{
        val users = forumUserService.getUsersByForum(id.toInt())

        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/{id}/threads")
    fun getThreadByForum(@PathVariable id: String): ResponseEntity<MutableList<ThreadsModel?>>{
        val threads = threadService.getThreadByForum(id.toInt())

        return ResponseEntity(threads, HttpStatus.OK)
    }

    @PostMapping("/{id}/thread")
    fun createThread(@RequestBody thread: ThreadsModel, @PathVariable id: String): ResponseEntity<ThreadsModel>{
        thread.forum_id = id.toInt()
        threadService.createThread(thread)

        return ResponseEntity(thread, HttpStatus.CREATED)
    }
}