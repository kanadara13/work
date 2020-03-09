package com.example.work.domain

import java.time.LocalDateTime

class URLMapperDto {
    var id = 0
    var code =""
    var url =""
    var createdAt: LocalDateTime = LocalDateTime.now()
    var count = 0

    fun isEmpty() = id == 0
}
