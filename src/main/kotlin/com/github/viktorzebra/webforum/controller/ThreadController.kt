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

@RestController
@RequestMapping("/api/v1/thread")
class ThreadResource(val threadService: ThreadsService,
                     val postService: PostService) {

    @GetMapping("/{id}")
    fun getThread(@PathVariable id: String): ResponseEntity<ThreadsModel>{
        val thread = threadService.getThreadById(id.toInt())

        return ResponseEntity(thread, HttpStatus.OK)
    }

    @GetMapping("/{id}/posts")
    fun getThreadPosts(@PathVariable id: String): ResponseEntity<MutableList<PostsModel?>>{
        val posts = postService.getPostsByThreadId(id)

        return ResponseEntity(posts, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateThread(@RequestBody thread: ThreadsModel, @PathVariable id: String): ResponseEntity<ThreadsModel>{
        threadService.updateThread(thread, id)

        return ResponseEntity(threadService.getThreadById(id.toInt()), HttpStatus.OK)
    }
}