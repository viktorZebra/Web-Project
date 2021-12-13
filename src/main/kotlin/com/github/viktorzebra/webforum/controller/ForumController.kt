package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.service.ForumService
import com.github.viktorzebra.webforum.service.ThreadsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/forum")
class ForumResource(val forumService: ForumService,
                    val threadService: ThreadsService){

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

    @PostMapping("/{id}/thread")
    fun createThread(@RequestBody thread: ThreadsModel, @PathVariable id: String): ResponseEntity<ThreadsModel>{
        thread.forum_id = id.toInt()
        threadService.createThread(thread)

        return ResponseEntity(thread, HttpStatus.CREATED)
    }
}