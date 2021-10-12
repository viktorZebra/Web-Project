package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ForumsModel
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
}