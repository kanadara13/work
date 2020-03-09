package com.example.work.controller

import com.example.work.domain.URLMapperDto
import com.example.work.service.URLMapperService
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/url")
class URLMapperController(private val urlMapperService : URLMapperService) {

    @GetMapping
    fun findUrl(@RequestParam("url") url: String) {
        //return urlMapperService.find()
    }

    @PostMapping
    suspend fun save(@RequestParam("url") url: String): Flow<URLMapperDto> {
        return urlMapperService.save(url)
    }
}