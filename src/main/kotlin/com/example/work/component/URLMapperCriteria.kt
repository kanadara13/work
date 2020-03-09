package com.example.work.component

import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapper
import com.example.work.entity.URLMapperTable
import org.springframework.stereotype.Component

@Component
class URLMapperCriteria {

    suspend fun findByCode(code : String): URLMapperDto = URLMapper.find { URLMapperTable.code eq code}.firstOrNull()?.toDto() ?:  URLMapperDto()
    fun findAll() = URLMapper.all()
}
