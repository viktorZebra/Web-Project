package com.github.viktorzebra.webforum.exception

import com.github.viktorzebra.webforum.model.UserModel

class UserAlreadyCreatedException(val userModel: UserModel) : RuntimeException() {
}
