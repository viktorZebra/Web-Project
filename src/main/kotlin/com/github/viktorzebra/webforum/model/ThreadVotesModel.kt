package com.github.viktorzebra.webforum.model

import org.springframework.data.relational.core.mapping.Table

@Table("thread_votes")
data class ThreadVotesModel(val voice: Int, val user_id: Int, val threads_id: Int,
                       val id: Int)