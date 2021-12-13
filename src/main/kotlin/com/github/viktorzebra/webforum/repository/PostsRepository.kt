package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.PostsModel
import org.springframework.data.repository.CrudRepository

interface PostsRepository : CrudRepository<PostsModel, Int> {
}