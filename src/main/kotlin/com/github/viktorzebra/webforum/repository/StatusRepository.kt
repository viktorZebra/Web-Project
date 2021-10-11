package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.StatusModel
import org.springframework.data.repository.CrudRepository

interface StatusRepository : CrudRepository<StatusModel, Int> {
}