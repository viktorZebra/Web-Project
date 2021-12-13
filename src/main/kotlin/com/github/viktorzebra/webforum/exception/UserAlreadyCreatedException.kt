package com.github.viktorzebra.webforum.exception

import com.github.viktorzebra.webforum.model.entity.UserEntity

class UserAlreadyCreatedException(val userModel: UserEntity?) : RuntimeException() {
}
