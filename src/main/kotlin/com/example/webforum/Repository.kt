package com.example.webforum

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface UserRepository : CrudRepository<User, Integer> {
    @Query("select * from users")
    fun selectAll(): List<User>
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

