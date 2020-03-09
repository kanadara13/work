package com.example.work.controller

import com.example.work.domain.URLMapperDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.util.Base64Utils
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.util.UriBuilder


@SpringBootTest
@AutoConfigureWebTestClient
internal class URLMapperControllerTest {

    @Autowired
    private val webClient: WebTestClient? = null

    @Test
    fun testCreateData() {
        val url = "https://www.musinsa.com/?m=news&uid=38728"
        webClient!!.post()
                .uri{ builder : UriBuilder -> builder.path("/api/url").queryParam("url",url).build() }
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .exchange()
                .expectStatus().isOk
    }
}