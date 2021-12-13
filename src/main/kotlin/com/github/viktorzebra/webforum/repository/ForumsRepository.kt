package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.ForumsEntity
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ForumsRepository : CrudRepository<ForumsEntity, Int> {

    @Query("select * from forums where slug = :slug")
    fun getForumBySlug(@Param("slug") slug: String): ForumsEntity?

    @Query("select COUNT(*) from forums where slug = :slug")
    fun getCountForum(@Param("slug") slug: String): Int
}