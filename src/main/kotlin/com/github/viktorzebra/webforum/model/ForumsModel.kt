package com.github.viktorzebra.webforum.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("forums")
data class ForumsModel(var author_id: Int,
                       var title: String,
                       var slug: String,
                       @Id var id: Int)