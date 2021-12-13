package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.ForumUsersEntity
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ForumUsersRepository : CrudRepository<ForumUsersEntity, Int> {

    @Query("select COUNT(*) from forum_users where user_id = :user_id and forum_id = :forum_id")
    fun isUserInForumExists(@Param("user_id") user_id: Int, @Param("forum_id") forum_id: Int): Int
}
