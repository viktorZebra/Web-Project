package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ThreadsModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ThreadsRepository : CrudRepository<ThreadsModel, Int> {
    @Query("select * from threads where slug = :slug")
    fun getThreadBySlug(@Param("slug") slug: String): ThreadsModel?

    @Query("select COUNT(*) from threads where id = :id")
    fun isThreadExistsById(@Param("id") id: Int): Int

    @Query("select * from threads where id = :id")
    fun getThreadById(@Param("id") id: Int): ThreadsModel?
}