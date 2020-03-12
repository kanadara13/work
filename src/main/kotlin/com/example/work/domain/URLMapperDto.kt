package com.example.work.domain

import com.example.work.entity.URLMapperEntity
import java.time.LocalDateTime

class URLMapperDto {
    var id = 0L
    var code =""
    var url =""
    var createdAt: LocalDateTime = LocalDateTime.now()
    var count = 0

    fun isEmpty() = id == 0L

    fun toEntity() = URLMapperEntity().also { it.id = id; it.code = code; it.url = url; it.createdAt =createdAt; it.count = count }


}
