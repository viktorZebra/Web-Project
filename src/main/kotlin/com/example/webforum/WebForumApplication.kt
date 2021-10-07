package com.example.webforum

import io.github.serpro69.kfaker.Faker
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.*


@SpringBootApplication
class WebForumApplication

fun main(args: Array<String>) {
    runApplication<WebForumApplication>(*args)
}

