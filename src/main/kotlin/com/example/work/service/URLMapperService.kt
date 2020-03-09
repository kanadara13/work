package com.example.work.service

import com.example.work.component.CodeGenerator
import com.example.work.component.URLMapperCriteria
import com.example.work.component.URLMapperSaver
import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapper
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class URLMapperService(private val saver : URLMapperSaver
                      ,private val codeGenerator: CodeGenerator
                      ,private val criteria : URLMapperCriteria
) {

    suspend fun save(url: String) =  saver.save(url, codeGenerator.generate())
    suspend fun find() = criteria.findAll()

}
