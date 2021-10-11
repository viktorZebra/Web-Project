package com.github.viktorzebra.webforum.model

import org.springframework.data.relational.core.mapping.Table

@Table("threads")
data class ThreadsModel(val id: Int, val forum: String, val title: String,
                   val votes: Int, val message: String, val slug: String,
                   val created: String,val author: String)