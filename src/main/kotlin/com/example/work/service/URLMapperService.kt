package com.example.work.service

import com.example.work.component.CodeGenerator
import com.example.work.component.URLMapperCriteria
import com.example.work.component.URLMapperSaver
import com.example.work.domain.URLMapperDto
import com.example.work.exception.DuplicateUrlException
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Service

@Service
class URLMapperService(private val saver : URLMapperSaver
                      ,private val codeGenerator: CodeGenerator
                      ,private val criteria : URLMapperCriteria
) {

    suspend fun save(url: String): URLMapperDto {
        val exist = criteria.findByURL(url)
        if (!exist.isEmpty()) {throw DuplicateUrlException("$url 은 이미 존재합니다")}
        return saver.save(url, codeGenerator.generate())
    }
    suspend fun find() = criteria.findAll().asFlow()

}
