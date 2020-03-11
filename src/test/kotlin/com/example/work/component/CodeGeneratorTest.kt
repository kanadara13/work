/*
package com.example.work.component

import com.example.work.domain.URLMapperDto
import com.example.work.entity.URLMapper
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CodeGeneratorTest {

    private lateinit var sut : CodeGenerator
    private lateinit var criteria: URLMapperCriteria

    @BeforeEach
    fun setUp() {
        criteria = mockk()
        sut = CodeGenerator(criteria)
    }


    @Test
    fun `generate until not found from db`(){
        coEvery { criteria.findByCode(any()) } returns  URLMapperDto().apply {this.id = 2} andThen URLMapperDto().apply { this.id=2 } andThen URLMapperDto().apply { this.id=2 } andThen URLMapperDto()
        runBlocking {
            sut.generate()
        }
        coVerify(exactly = 4) { criteria.findByCode(any()) }
    }


}
*/
