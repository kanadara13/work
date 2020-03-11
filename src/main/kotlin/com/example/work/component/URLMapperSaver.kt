package com.example.work.component

import com.example.work.domain.URLMapperDto
/*import com.example.work.entity.URLMapper*/
import com.example.work.entity.URLMapperEntity
/*import com.example.work.entity.URLMapperTable*/
import com.example.work.repository.URLMapperRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Component
class URLMapperSaver(private val repository: URLMapperRepository) {

    @Transactional
    suspend fun save(url : String, code : String) : URLMapperDto {
        return repository.save(URLMapperEntity().apply { this.code = code; this.count=0; this.url = url }).toDto()
       /* val saved = URLMapper.new {
            this.code = code
            this.count = 0
            this.createdAt = LocalDateTime.now()
            this.url = url
        }
        return saved.toDto()*/
    }

 /*   @Transactional
    fun update(dto: URLMapperDto) {
        URLMapperTable.update({URLMapperTable.code eq dto.code}) {
            it[this.count] = dto.count + 1
        }
    }*/
}