package com.github.viktorzebra.webforum.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("forums")
data class ForumsModel(var user_nickname: String, var title: String, var slug: String,
                       var posts: Int, var threads: Int, @Id var id: Int)