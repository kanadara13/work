package com.example.work.controller

import com.example.work.service.URLMapperService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.result.view.RedirectView

@Controller
class FrontController(private val urlMapperService : URLMapperService) {

    @GetMapping("/")
    fun getUser() : String = "input"

    @GetMapping("/{code}")
    suspend fun findUrl(@PathVariable("code") code: String) : RedirectView {
        if (code == "favicon.ico") {return RedirectView("/")}
        val mapper = urlMapperService.mapping(code)
        if (mapper.isEmpty()) {return RedirectView("/")}
        return RedirectView(mapper.url)
    }
}