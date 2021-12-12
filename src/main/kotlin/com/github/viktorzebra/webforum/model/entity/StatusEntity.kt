package com.github.viktorzebra.webforum.model.entity

import org.springframework.data.relational.core.mapping.Table

@Table("status")
data class StatusEntity(
    val threads: Int,
    val posts: Int,
    val forums: Int,
    val users: Int
    )