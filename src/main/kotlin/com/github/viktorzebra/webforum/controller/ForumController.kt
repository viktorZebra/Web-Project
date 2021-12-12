package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.entity.ForumsEntity
import com.github.viktorzebra.webforum.service.ForumService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/forum")
class ForumResource(val forumService: ForumService){

    @PostMapping("/create")
    fun create(@RequestBody forum: ForumsEntity): ResponseEntity<ForumsEntity>{
        forumService.create(forum)

        return ResponseEntity(forum, HttpStatus.CREATED)
    }

    @GetMapping("/{slug}/details")
    fun getForumInfo(@PathVariable slug: String): ResponseEntity<ForumsEntity>{
        val forum = forumService.getForumBySlug(slug)

        return ResponseEntity(forum, HttpStatus.OK)
    }
}