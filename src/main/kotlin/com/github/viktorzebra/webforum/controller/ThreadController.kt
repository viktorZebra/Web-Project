package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.ThreadsModel
import com.github.viktorzebra.webforum.service.ThreadsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Service
@RequestMapping("/api/v1/thread")
class ThreadResource(val threadService: ThreadsService) {

    @PostMapping("/{slugForum}/create")
    fun createThread(@RequestBody thread: ThreadsModel, @PathVariable slugForum: String): ResponseEntity<ThreadsModel>{
        thread.forum = slugForum
        threadService.createThread(thread)

        return ResponseEntity(thread, HttpStatus.CREATED)
    }
}