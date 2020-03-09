package com.example.work.service

import com.example.work.component.CodeGenerator
import com.example.work.component.URLMapperSaver
import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapper
import kotlinx.coroutines.flow.flow
import org.springframework.stereotype.Service

@Service
class URLMapperService(private val saver : URLMapperSaver, private val codeGenerator: CodeGenerator) {

    suspend fun save(url: String) = flow<URLMapperDto> { saver.save(url, codeGenerator.generate()) }

}
