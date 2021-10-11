package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ForumUsersModel
import org.springframework.data.repository.CrudRepository

interface ForumUsersRepository : CrudRepository<ForumUsersModel, Int> {
}
