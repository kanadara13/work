package com.example.work.component

import kotlinx.coroutines.runBlocking
import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class URLMapperCriteriaTest {

    @Autowired
    private lateinit var sut : URLMapperCriteria

    @Test
    fun `when not found data`(){
        runBlocking {
            val result = sut.findByCode("!!")
            assertTrue(result.isEmpty())
        }
    }
}