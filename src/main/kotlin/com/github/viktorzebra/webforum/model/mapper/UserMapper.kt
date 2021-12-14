package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.User
import com.github.viktorzebra.webforum.model.dto.UserDto
import com.github.viktorzebra.webforum.model.entity.UserEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun convertEntityToModel(userEntity: UserEntity) : User

    fun convertModelToEntity(user: User) : UserEntity

    fun convertModelToDto(user: User) : UserDto

    fun convertDtoToModel(userDto: UserDto) : User
}