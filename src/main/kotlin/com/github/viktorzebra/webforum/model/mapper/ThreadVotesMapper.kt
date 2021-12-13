package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.ThreadVotes
import com.github.viktorzebra.webforum.model.dto.ThreadVotesDto
import com.github.viktorzebra.webforum.model.entity.ThreadVotesEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ThreadVotesMapper {
    fun convertEntityToModel(threadVotesEntity: ThreadVotesEntity) : ThreadVotes

    fun convertModelToEntity(threadVotes: ThreadVotes) : ThreadVotesEntity

    fun convertModelToDto(threadVotes: ThreadVotes) : ThreadVotesDto

    fun convertDtoToModel(threadVotesDto: ThreadVotesDto) : ThreadVotes
}