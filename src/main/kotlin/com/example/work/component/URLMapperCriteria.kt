package com.example.work.component

import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapper
import com.example.work.entity.URLMapperTable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class URLMapperCriteria {

    suspend fun findByCode(code : String): URLMapperDto = URLMapper.find { URLMapperTable.code eq code}.firstOrNull()?.toDto() ?:  URLMapperDto()
    suspend fun findAll() : List<URLMapperDto> = URLMapper.all().map { e->e.toDto() }
}
