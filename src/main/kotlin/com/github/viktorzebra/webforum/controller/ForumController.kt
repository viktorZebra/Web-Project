package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.dto.ForumsDto
import com.github.viktorzebra.webforum.model.dto.ThreadsDto
import com.github.viktorzebra.webforum.model.dto.UserDto
import com.github.viktorzebra.webforum.model.mapper.ForumsMapper
import com.github.viktorzebra.webforum.model.mapper.ThreadsMapper
import com.github.viktorzebra.webforum.model.mapper.UserMapper
import com.github.viktorzebra.webforum.service.ForumService
import com.github.viktorzebra.webforum.service.ForumUsersService
import com.github.viktorzebra.webforum.service.ThreadsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/forum")
class ForumResource(val forumService: ForumService,
                    val threadService: ThreadsService,
                    val forumUserService: ForumUsersService,
                    val convertForum: ForumsMapper,
                    val convertUser: UserMapper,
                    val convertThread: ThreadsMapper) {

    @PostMapping
    fun createForum(@RequestBody forum: ForumsDto): ResponseEntity<ForumsDto>{
        forumService.create(forum.let { convertForum.convertDtoToModel(it) })

        return ResponseEntity(forum, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getForum(@PathVariable id: String): ResponseEntity<ForumsDto>{
        val forum = forumService.getForumById(id)

        return ResponseEntity(forum.let { convertForum.convertModelToDto(it) }, HttpStatus.OK)
    }

    @GetMapping("/{id}/users")
    fun getUsersByForum(@PathVariable id: String): ResponseEntity<List<UserDto?>>{
        val users = forumUserService.getUsersByForum(id.toInt())

        return ResponseEntity(users.filterNotNull().map { convertUser.convertModelToDto(it) }, HttpStatus.OK)
    }

    @GetMapping("/{id}/threads")
    fun getThreadByForum(@PathVariable id: String): ResponseEntity<List<ThreadsDto?>>{
        val threads = threadService.getThreadByForum(id.toInt())

        return ResponseEntity(threads.filterNotNull().map { convertThread.convertModelToDto(it) }, HttpStatus.OK)
    }

    @PostMapping("/{id}/thread")
    fun createThread(@RequestBody thread: ThreadsDto, @PathVariable id: String): ResponseEntity<ThreadsDto>{
        thread.forum_id = id.toInt()
        threadService.createThread(thread.let { convertThread.convertDtoToModel(it) })

        return ResponseEntity(thread, HttpStatus.CREATED)
    }
}