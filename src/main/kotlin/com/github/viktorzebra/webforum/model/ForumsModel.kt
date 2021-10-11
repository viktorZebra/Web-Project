package com.github.viktorzebra.webforum.model

import org.springframework.data.relational.core.mapping.Table

@Table("forums")
data class ForumsModel(val user_nickname: String, val title: String, val treads: Int,
                       val posts: Int, val slug: String, val id: Int)