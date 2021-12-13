package com.github.viktorzebra.webforum.model.dto

data class StatusDto(
    val threads: Int,
    val posts: Int,
    val forums: Int,
    val users: Int
)