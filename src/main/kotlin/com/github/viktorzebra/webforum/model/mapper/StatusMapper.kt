package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.Status
import com.github.viktorzebra.webforum.model.dto.StatusDto
import com.github.viktorzebra.webforum.model.entity.StatusEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface StatusMapper {
    fun convertEntityToModel(statusEntity: StatusEntity) : Status

    fun convertModelToEntity(status: Status) : StatusEntity

    fun convertModelToDto(status: Status) : StatusDto

    fun convertDtoToModel(statusDto: StatusDto) : Status
}