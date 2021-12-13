package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.PostsModel
import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.model.UserModel
import com.github.viktorzebra.webforum.service.PostService
import com.github.viktorzebra.webforum.service.ThreadsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
@RequestMapping("/api/v1/post")
class PostResource(val postService: PostService) {

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: String): ResponseEntity<PostsModel>{
        val post = postService.getPostById(id)

        return ResponseEntity(post, HttpStatus.OK)
    }

    @PostMapping
    fun createThread(@RequestBody post: PostsModel): ResponseEntity<PostsModel> {
        postService.createPost(post)

        return ResponseEntity(post, HttpStatus.CREATED)
    }

    @PatchMapping("/{id}")
    fun updatePost(@RequestBody post: PostsModel, @PathVariable id: String): ResponseEntity<PostsModel>{
        postService.updatePost(post, id)

        return ResponseEntity(postService.getPostById(id), HttpStatus.OK)
    }
}