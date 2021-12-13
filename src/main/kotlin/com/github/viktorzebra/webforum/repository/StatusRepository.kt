package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.StatusEntity
import org.springframework.data.repository.CrudRepository

interface StatusRepository : CrudRepository<StatusEntity, Int> {
}