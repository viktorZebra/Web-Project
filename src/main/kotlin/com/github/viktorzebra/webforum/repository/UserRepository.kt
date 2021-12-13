package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.UserEntity
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : CrudRepository<UserEntity, Integer> {
    @Query("select * from users")
    fun selectAll(): List<UserEntity>

    @Query("select * from users where nickname = :nickname")
    fun getUserByNickname(@Param("nickname") nickname: String): UserEntity?

    @Query("select COUNT(*) from users where email = :email")
    fun isUserWithEmailExists(@Param("email") email: String): Int

    @Query("select COUNT(*) from users where nickname = :nickname")
    fun getCountUsersByNickname(@Param("nickname") nickname: String): Int

    @Query("select * from users where email = :email")
    fun getUserByEmail(@Param("email") email: String): UserEntity?
}


