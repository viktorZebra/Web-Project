package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.UserModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : CrudRepository<UserModel, Integer> {
    @Query("select * from users")
    fun selectAll(): List<UserModel>

    @Query("select * from users where nickname = :nickname")
    fun getUserByNickname(@Param("nickname") nickname: String): UserModel?
}


