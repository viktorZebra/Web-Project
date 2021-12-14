package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.Forums
import com.github.viktorzebra.webforum.model.dto.ForumsDto
import com.github.viktorzebra.webforum.model.entity.ForumsEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ForumsMapper {
    fun convertEntityToModel(forumsEntity: ForumsEntity) : Forums

    fun convertModelToEntity(forums: Forums) : ForumsEntity

    fun convertModelToDto(forums: Forums) : ForumsDto

    fun convertDtoToModel(forumsDto: ForumsDto) : Forums
}