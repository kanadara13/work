/*
package com.example.work.component

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class URLMapperSaverTest {

    private lateinit var sut : URLMapperSaver

    @BeforeEach
    fun setUp() {
        sut = URLMapperSaver()
    }

    @Test
    fun `SHOULD SAVE return entity equal check`() {
        runBlocking {
            val saved = sut.save("https://www.naver.com","musinsas")
            assertEquals(saved.code,"musinsas")
        }
    }
}*/
