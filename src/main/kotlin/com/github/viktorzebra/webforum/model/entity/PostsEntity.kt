package com.github.viktorzebra.webforum.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.time.Instant

@Table("posts")
data class PostsEntity(
    var path: MutableList<Int>? = null,
    @Id var id: Int? = null,
    var parent: Int,
    var author: String,
    var forum: String = "default",
    var created: Timestamp = Timestamp.from(Instant.now()),
    var message: String,
    var thread: Int,
    var is_edited: Boolean = false
)