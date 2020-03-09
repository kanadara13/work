package com.example.work.component

import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Component
class URLMapperSaver {
/*
    @Transactional
    suspend fun save(url : String, code : String) = withContext(Dispatchers.IO) {
            val saved = URLMapper.new {
                this.code = code
                this.count = 0
                this.createdAt = LocalDateTime.now()
                this.url = url
            }
            saved.toDto()
        }*/

    @Transactional
    suspend fun save(url : String, code : String) : URLMapperDto {
        val saved = URLMapper.new {
            this.code = code
            this.count = 0
            this.createdAt = LocalDateTime.now()
            this.url = url
        }
        return saved.toDto()
    }
}