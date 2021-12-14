package com.github.viktorzebra.webforum.model

data class Statistics(
    val count_users: Int,
    val count_forums: Int,
    val count_threads: Int,
    val most_popular_user: Int,
    val most_viewed_profile: Int
)