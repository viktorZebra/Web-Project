package com.github.viktorzebra.webforum.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class UserModel(val fullname: String, val email: String, val nickname: String,
                val about: String, @Id var id: Int? = null)
