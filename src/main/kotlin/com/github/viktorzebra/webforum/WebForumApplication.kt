package com.github.viktorzebra.webforum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

class WebForumApplication

fun main(args: Array<String>) {
    runApplication<WebForumApplication>(*args)
}

