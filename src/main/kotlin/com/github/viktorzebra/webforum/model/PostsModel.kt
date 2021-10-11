package com.github.viktorzebra.webforum.model

import org.springframework.data.relational.core.mapping.Table

@Table("posts")
data class PostsModel(val path: Int, val id: Int, val parent: Int,
                      val author: String, val forum: String, val created: String,
                      val message: String, val thread: Int, val is_edited: Boolean)