package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.Threads
import com.github.viktorzebra.webforum.model.dto.ThreadsDto
import com.github.viktorzebra.webforum.model.entity.ThreadsEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ThreadsMapper {
    fun convertEntityToModel(threadsEntity: ThreadsEntity) : Threads

    fun convertModelToEntity(threads: Threads) : ThreadsEntity

    fun convertModelToDto(threads: Threads) : ThreadsDto

    fun convertDtoToModel(threadsDto: ThreadsDto) : Threads
}