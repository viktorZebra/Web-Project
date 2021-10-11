package com.github.viktorzebra.webforum.model

import org.springframework.data.relational.core.mapping.Table

@Table("forum_users")
data class ForumUsersModel(val user_id: Int, val forum_id: Int)