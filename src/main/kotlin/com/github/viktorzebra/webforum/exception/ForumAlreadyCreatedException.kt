package com.github.viktorzebra.webforum.exception

import com.github.viktorzebra.webforum.model.ForumsModel

class ForumAlreadyCreatedException(val forumsModel: ForumsModel) : RuntimeException() {
}
