package com.example.work.component

import com.example.work.domain.URLMapperDto
import com.example.work.repository.URLMapperRepository
import org.springframework.stereotype.Component

@Component
class URLMapperCriteria(private val repository: URLMapperRepository) {

    suspend fun findByCode(code : String): URLMapperDto = repository.findByCode(code)?.toDto() ?: URLMapperDto()
    suspend fun findAll() : List<URLMapperDto> = repository.findAll().map { e->e.toDto() }
    suspend fun findByURL(url: String): URLMapperDto = repository.findByUrl(url)?.toDto() ?: URLMapperDto()
}
