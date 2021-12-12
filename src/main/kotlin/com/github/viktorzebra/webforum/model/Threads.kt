package com.github.viktorzebra.webforum.model

import java.sql.Timestamp
import java.time.Instant

data class Threads(
    var id: Int? = null,
    var forum: String = "default",
    var title: String,
    var votes: Int,
    var message: String,
    var slug: String,
    var created: Timestamp,
    var author: String
)