package com.github.viktorzebra.webforum.exception

import com.github.viktorzebra.webforum.model.ThreadsModel

class ThreadAlreadyCreatedException(val existedThread: ThreadsModel) : RuntimeException()
