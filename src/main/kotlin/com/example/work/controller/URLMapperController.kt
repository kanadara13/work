package com.example.work.controller

import ErrorResponse
import com.example.work.domain.SaveRequest
import com.example.work.domain.URLMapperDto
import com.example.work.exception.DuplicateUrlException
import com.example.work.service.URLMapperService
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.netty.http.server.HttpServerResponse
import java.lang.Exception

@RestController
@RequestMapping("/api/url")
class URLMapperController(private val urlMapperService : URLMapperService) {

    /*@GetMapping
    fun findUrl(@RequestParam("url") url: String) {
        //return urlMapperService.find()
    }*/

    @GetMapping
    suspend fun findAll() : Flow<URLMapperDto> = urlMapperService.find()

    @PostMapping
    suspend fun save(request : SaveRequest) = try {
                ResponseEntity(urlMapperService.save(request.url), HttpStatus.OK)
            } catch(ex : Exception) { ResponseEntity(ErrorResponse(ex.javaClass.simpleName, HttpStatus.BAD_REQUEST.name, "${ex.message}"),HttpStatus.BAD_REQUEST) }
}