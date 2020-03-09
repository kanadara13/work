package com.example.work.controller

import com.example.work.domain.SaveRequest
import com.example.work.domain.URLMapperDto
import com.example.work.service.URLMapperService
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/url")
class URLMapperController(private val urlMapperService : URLMapperService) {

    /*@GetMapping
    fun findUrl(@RequestParam("url") url: String) {
        //return urlMapperService.find()
    }*/

    @GetMapping
    fun findAll() = urlMapperService.find()

    @PostMapping
    suspend fun save(request : SaveRequest) = urlMapperService.save(request.url)
}