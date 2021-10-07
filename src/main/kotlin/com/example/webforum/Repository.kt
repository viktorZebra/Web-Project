package com.example.webforum

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : CrudRepository<User, Integer> {
    @Query("select * from users")
    fun selectAll(): List<User>

    @Query("select * from users where nickname = :nickname")
    fun getUserByNickname(@Param("nickname") nickname: String): User?
}

interface ForumUsersRepository : CrudRepository<ForumUsers, Int> {
}

interface ForumsRepository : CrudRepository<Forums, Int> {
}

interface PostsRepository : CrudRepository<Posts, Int> {
}

interface StatusRepository : CrudRepository<Status, Int>{
}

interface ThreadVotesRepository : CrudRepository<ThreadVotes, Int>{
}

interface ThreadsRepository : CrudRepository<Threads, Int>{
}

