package com.example.work.domain

import java.time.LocalDateTime

class URLMapperDto {
    var code =""
    var url =""
    var createdAt: LocalDateTime = LocalDateTime.now()
    var count = 0
}
