package com.github.viktorzebra.webforum.model

import java.sql.Timestamp
import java.time.Instant

data class Posts(
    var path: MutableList<Int>? = null,
    var id: Int? = null,
    var parent: Int,
    var author: String,
    var forum: String = "default",
    var created: Timestamp,
    var message: String,
    var thread: Int,
    var is_edited: Boolean = false
)