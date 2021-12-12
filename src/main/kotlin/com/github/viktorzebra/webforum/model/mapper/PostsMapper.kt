package com.github.viktorzebra.webforum.model.mapper

import com.github.viktorzebra.webforum.model.Posts
import com.github.viktorzebra.webforum.model.dto.PostsDto
import com.github.viktorzebra.webforum.model.entity.PostsEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PostsMapper {
    fun convertEntityToModel(postsEntity: PostsEntity) : Posts

    fun convertModelToEntity(posts: Posts) : PostsEntity

    fun convertModelToDto(posts: Posts) : PostsDto

    fun convertDtoToModel(postsDto: PostsDto) : Posts
}