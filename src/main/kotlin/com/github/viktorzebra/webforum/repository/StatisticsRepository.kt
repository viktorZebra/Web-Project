package com.github.viktorzebra.webforum.repository

import com.github.viktorzebra.webforum.model.entity.StatisticsEntity
import org.springframework.data.repository.CrudRepository

interface StatisticsRepository : CrudRepository<StatisticsEntity, Int> {
}