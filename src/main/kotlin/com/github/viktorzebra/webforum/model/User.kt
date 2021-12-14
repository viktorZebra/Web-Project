package com.github.viktorzebra.webforum.model

data class User(
    var fullname: String,
    var email: String,
    var nickname: String? = null,
    var about: String,
    var count_view_profile: Int,
    var id: Int
)