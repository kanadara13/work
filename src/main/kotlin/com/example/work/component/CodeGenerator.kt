package com.example.work.component

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Component

@Component
class CodeGenerator(private val criteria: URLMapperCriteria) {

    suspend fun generate(): String {
        while (true) {
            val code = RandomStringUtils.randomAlphabetic(8,8)
            val fromDB = criteria.findByCode(code)
            if (fromDB.isEmpty()) {return code}
        }
    }
}