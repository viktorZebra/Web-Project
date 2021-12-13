package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ForumsModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ForumsRepository : CrudRepository<ForumsModel, Int> {

    @Query("select * from forums where slug = :slug")
    fun getForumBySlug(@Param("slug") slug: String): ForumsModel?

    @Query("select * from forums where id = :id")
    fun getForumById(@Param("id") id: Int): ForumsModel?

    @Query("select COUNT(*) from forums where slug = :slug")
    fun getCountForum(@Param("slug") slug: String): Int
}