package com.condconv.vertical.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = arrayOf(
        "com.condconv.vertical.users.api",
        "com.condconv.vertical.products.api"
    )
)
class VerticalApplication

fun main(args: Array<String>) {
    runApplication<VerticalApplication>(*args)
}
