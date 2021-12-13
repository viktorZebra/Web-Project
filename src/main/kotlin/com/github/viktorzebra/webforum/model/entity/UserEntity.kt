package com.github.viktorzebra.webforum.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class UserEntity(var fullname: String, var email: String, var nickname: String? = null,
                      var about: String, @Id var id: Int)
