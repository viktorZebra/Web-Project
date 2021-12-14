package com.github.viktorzebra.webforum.exception

import com.github.viktorzebra.webforum.model.entity.ThreadsEntity

class ThreadAlreadyCreatedException(val existedThread: ThreadsEntity) : RuntimeException()
