package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ThreadsModel
import org.springframework.data.repository.CrudRepository

interface ThreadsRepository : CrudRepository<ThreadsModel, Int> {
}