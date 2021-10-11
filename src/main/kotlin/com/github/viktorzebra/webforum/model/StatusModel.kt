package com.github.viktorzebra.webforum.model

import org.springframework.data.relational.core.mapping.Table

@Table("status")
data class StatusModel(val threads: Int, val posts: Int, val forums: Int,
                       val users: Int)