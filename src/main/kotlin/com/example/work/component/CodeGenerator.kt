package com.example.work.component

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CodeGenerator(private val criteria: URLMapperCriteria) {

    @Transactional
    suspend fun generate(): String {
        while (true) {
            val code = RandomStringUtils.randomAlphabetic(8,8)
            val fromDB = criteria.findByCode(code)
            if (fromDB.isEmpty()) {return code}
        }
    }
}