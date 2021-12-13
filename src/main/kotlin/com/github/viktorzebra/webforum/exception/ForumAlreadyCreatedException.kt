package com.github.viktorzebra.webforum.exception

import com.github.viktorzebra.webforum.model.entity.ForumsEntity

class ForumAlreadyCreatedException(val forumsModel: ForumsEntity) : RuntimeException() {
}
