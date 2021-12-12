package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.ForumUsers
import com.github.viktorzebra.webforum.model.dto.ForumUsersDto
import com.github.viktorzebra.webforum.model.entity.ForumUsersEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ForumUsersMapper {
    fun convertEntityToModel(forumUsersEntity: ForumUsersEntity) : ForumUsers

    fun convertModelToEntity(forumUsers: ForumUsers) : ForumUsersEntity

    fun convertModelToDto(forumUsers: ForumUsers) : ForumUsersDto

    fun convertDtoToModel(forumUsersDto: ForumUsersDto) : ForumUsers
}