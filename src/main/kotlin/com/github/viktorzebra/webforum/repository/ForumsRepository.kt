package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.ForumsModel
import org.springframework.data.repository.CrudRepository

interface ForumsRepository : CrudRepository<ForumsModel, Int> {
}