package com.example.work.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FrontController {

    @GetMapping("/")
    fun getUser() : String? {
        return "input"
    }
}