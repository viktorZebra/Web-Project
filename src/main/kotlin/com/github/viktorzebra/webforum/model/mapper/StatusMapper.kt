package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.Statistics
import com.github.viktorzebra.webforum.model.dto.StatisticsDto
import com.github.viktorzebra.webforum.model.entity.StatisticsEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface StatusMapper {
    fun convertEntityToModel(statusEntity: StatisticsEntity) : Statistics

    fun convertModelToEntity(status: Statistics) : StatisticsEntity

    fun convertModelToDto(status: Statistics) : StatisticsDto

    fun convertDtoToModel(statusDto: StatisticsDto) : Statistics
}