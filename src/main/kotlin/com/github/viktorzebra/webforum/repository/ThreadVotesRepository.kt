package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.ThreadVotesEntity
import org.springframework.data.repository.CrudRepository

interface ThreadVotesRepository : CrudRepository<ThreadVotesEntity, Int> {
}