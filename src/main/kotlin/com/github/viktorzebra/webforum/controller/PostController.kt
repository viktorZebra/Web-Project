package com.github.viktorzebra.webforum.controller

import com.github.viktorzebra.webforum.model.PostsModel
import com.github.viktorzebra.webforum.model.dto.PostsDto
import com.github.viktorzebra.webforum.model.mapper.PostsMapper
import com.github.viktorzebra.webforum.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
@RequestMapping("/api/v1/post")
class PostResource(val postService: PostService, val convert: PostsMapper) {

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: String): ResponseEntity<PostsDto>{
        val post = postService.getPostById(id).let { convert.convertModelToDto(it) }

        return ResponseEntity(post, HttpStatus.OK)
    }

    @PostMapping
    fun createThread(@RequestBody post: PostsDto): ResponseEntity<PostsDto> {
        postService.createPost(post.let { convert.convertDtoToModel(it) })

        return ResponseEntity(post, HttpStatus.CREATED)
    }

    @PatchMapping("/{id}")
    fun updatePost(@RequestBody post: PostsDto, @PathVariable id: String): ResponseEntity<PostsDto>{
        postService.updatePost(post.let { convert.convertDtoToModel(it) }, id)

        return ResponseEntity(postService.getPostById(id).let { convert.convertModelToDto(it) }, HttpStatus.OK)
    }
}