package com.example.work.controller

import com.example.work.service.URLMapperService
import io.netty.handler.codec.http.HttpResponseStatus.TEMPORARY_REDIRECT
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.result.view.RedirectView
import reactor.core.publisher.Mono
import java.net.URI

@Controller
class FrontController(private val urlMapperService : URLMapperService) {

    @GetMapping("/")
    fun getUser() : String = "input"

    /*@GetMapping("/{code}")
    suspend fun findUrl(@PathVariable("code") code: String) : RedirectView {
        val mapper = urlMapperService.mapping(code)
        if (mapper.isEmpty()) {return RedirectView("/")}
        return RedirectView(mapper.url)
    }*/
}