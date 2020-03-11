package com.example.work.component

import com.example.work.domain.URLMapperDto
/*import com.example.work.entity.URLMapper
import com.example.work.entity.URLMapperTable*/
import com.example.work.repository.URLMapperRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class URLMapperCriteria(private val repository: URLMapperRepository) {

    //suspend fun findByCode(code : String): URLMapperDto = URLMapper.find { URLMapperTable.code eq code}.firstOrNull()?.toDto() ?:  URLMapperDto()
    //fun findAll() : List<URLMapperDto> = URLMapper.all().map { e->e.toDto() }
    suspend fun findAll() : List<URLMapperDto> = repository.findAll().map { e->e.toDto() }
    //suspend fun findByURL(url: String): URLMapperDto = URLMapper.find { URLMapperTable.url eq url}.firstOrNull()?.toDto() ?:  URLMapperDto()
}
