package com.example.work.controller

import com.example.work.domain.ErrorResponse
import com.example.work.domain.SaveRequest
import com.example.work.domain.URLMapperDto
import com.example.work.service.URLMapperService
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/url")
class URLMapperController(private val urlMapperService : URLMapperService) {

    @GetMapping
    suspend fun findAll() : Flow<URLMapperDto> = urlMapperService.find()

 /*   @PostMapping
    suspend fun save(request : SaveRequest) = try {
            request.validate()
            ResponseEntity(urlMapperService.save(request.url), HttpStatus.OK)
    } catch(ex : Exception) {
        ResponseEntity(ErrorResponse(ex.javaClass.simpleName, HttpStatus.BAD_REQUEST.name, "${ex.message}"),HttpStatus.BAD_REQUEST)
    }*/
}