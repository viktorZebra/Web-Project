package com.github.viktorzebra.webforum.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.time.Instant

@Table("threads")
data class ThreadsEntity(
    @Id var id: Int? = null,
    var forum: String = "default",
    var title: String,
    var votes: Int,
    var message: String,
    var slug: String,
    var created: Timestamp = Timestamp.from(Instant.now()),
    var author: String
    )