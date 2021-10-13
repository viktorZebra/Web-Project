package com.github.viktorzebra.webforum.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("posts")
data class PostsModel(var path: Int, @Id var id: Int, var parent: Int,
                      var author: String, var forum: String, var created: String,
                      var message: String, var thread: Int, var is_edited: Boolean)