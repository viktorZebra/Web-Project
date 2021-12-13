package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ForumsModel
import com.github.viktorzebra.webforum.model.PostsModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface PostsRepository : CrudRepository<PostsModel, Int> {
    @Query("select * from posts where thread_id = :id")
    fun getPostsByThreadId(@Param("id") id: Int): MutableList<PostsModel?>
}