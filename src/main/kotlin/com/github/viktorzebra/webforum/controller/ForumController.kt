package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.service.ForumService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/forum")
class ForumResource(val forumService: ForumService){

    @PostMapping("/create")
    fun create(@RequestBody forum: ForumsModel): ResponseEntity<ForumsModel>{
        forumService.create(forum)

        return ResponseEntity(forum, HttpStatus.CREATED)
    }

    @GetMapping("/{slug}/details")
    fun getForumInfo(@PathVariable slug: String): ResponseEntity<ForumsModel>{
        val forum = forumService.getForumBySlug(slug)

        return ResponseEntity(forum, HttpStatus.OK)
    }

    @PostMapping("/{slugForum}/create")
    fun createThread(@RequestBody thread: ThreadsModel, @PathVariable slugForum: String): ResponseEntity<ThreadsModel>{
        thread.forum = slugForum
        forumService.createThread(thread)

        return ResponseEntity(thread, HttpStatus.CREATED)
    }
}