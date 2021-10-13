package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.PostsModel
import com.github.viktorzebra.webforum.repository.ThreadsRepository
import com.github.viktorzebra.webforum.service.ThreadsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Service
@RequestMapping("/api/thread")
class ThreadController(val threadsService: ThreadsService) {

//    @PostMapping("/{slug_or_id}/create")
//    fun create(@RequestBody post: PostsModel, @PathVariable slug: String): ResponseEntity<PostsModel> {
//        threadsService.create(post, slug)
//
//        return ResponseEntity(post, HttpStatus.CREATED)
//    }

}