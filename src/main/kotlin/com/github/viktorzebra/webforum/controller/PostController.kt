package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.entity.PostsEntity
import com.github.viktorzebra.webforum.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Service
@RequestMapping("/api/v1/post")
class PostResource(val postService: PostService) {

    @PostMapping("/{threadID}/create")
    fun createPost(@RequestBody post: PostsEntity, @PathVariable threadID: Int): ResponseEntity<PostsEntity> {
        post.thread = threadID
        postService.createPost(post)

        return ResponseEntity(post, HttpStatus.CREATED)
    }
}