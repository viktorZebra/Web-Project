package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.PostsEntity
import org.springframework.data.repository.CrudRepository

interface PostsRepository : CrudRepository<PostsEntity, Int> {
}