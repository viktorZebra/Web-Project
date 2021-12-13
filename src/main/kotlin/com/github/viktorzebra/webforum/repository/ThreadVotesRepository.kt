package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ThreadVotesModel
import org.springframework.data.repository.CrudRepository

interface ThreadVotesRepository : CrudRepository<ThreadVotesModel, Int> {
}