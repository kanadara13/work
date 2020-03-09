package com.example.work

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WorkApplication

fun main(args: Array<String>) {
    runApplication<WorkApplication>(*args)
}
