package com.example.work.component

import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapperEntity
import com.example.work.repository.URLMapperRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class URLMapperSaver(private val repository: URLMapperRepository) {

    @Transactional
    suspend fun save(url : String, code : String) : URLMapperDto {
        return repository.save(URLMapperEntity().apply { this.code = code; this.count=0; this.url = url }).toDto()
    }

    @Transactional
    fun update(dto: URLMapperDto) {
        repository.save(dto.toEntity())
    }
}