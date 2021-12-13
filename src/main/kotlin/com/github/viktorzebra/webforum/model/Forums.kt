package com.github.viktorzebra.webforum.model

data class Forums(
    var user_nickname: String,
    var title: String,
    var slug: String,
    var posts: Int,
    var threads: Int,
    var id: Int
)