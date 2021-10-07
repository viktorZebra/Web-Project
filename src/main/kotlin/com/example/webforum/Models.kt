package com.example.webforum

import io.github.serpro69.kfaker.Faker
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(val fullname: String, val email: String, val nickname: String, val about: String, @Id var id: Int? = null)

@Table("forum_users")
data class ForumUsers(val user_id: Int, val forum_id: Int)

@Table("forums")
data class Forums(val user_nickname: String, val title: String, val treads: Int, val posts: Int, val slug: String, val id: Int)

@Table("posts")
data class Posts(val path: Int, val id: Int, val parent: Int, val author: String, val forum: String, val created: String, val message: String, val thread: Int, val is_edited: Boolean)

@Table("status")
data class Status(val threads: Int, val posts: Int, val forums: Int, val users: Int)

@Table("thread_votes")
data class ThreadVotes(val voice: Int, val user_id: Int, val threads_id: Int, val id: Int)

@Table("threads")
data class Threads(val id: Int, val forum: String, val title: String, val votes: Int, val message: String, val slug: String, val created: String,val author: String)