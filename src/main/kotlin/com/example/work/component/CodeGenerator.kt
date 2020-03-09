package com.example.work.component

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Component

@Component
class CodeGenerator {

    suspend fun generate(): String = RandomStringUtils.randomAlphabetic(8,8)
    
}