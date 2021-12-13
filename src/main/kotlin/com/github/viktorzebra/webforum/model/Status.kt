package com.github.viktorzebra.webforum.model

data class Status(
    val threads: Int,
    val posts: Int,
    val forums: Int,
    val users: Int
)