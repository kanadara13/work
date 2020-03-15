package com.example.work.service

import com.example.work.component.CodeGenerator
import com.example.work.component.URLMapperCriteria
import com.example.work.component.URLMapperSaver
import com.example.work.config.MyWebSocketHandler
import com.example.work.domain.URLMapperDto
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Service
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration


@Service
class URLMapperService(private val saver : URLMapperSaver
                      ,private val codeGenerator: CodeGenerator
                      ,private val criteria : URLMapperCriteria
                      ,private val socketHandler: MyWebSocketHandler
) {
    suspend fun save(url: String): URLMapperDto {
        val exist = criteria.findByURL(url)
        if (!exist.isEmpty()) { return exist}
        return saver.save(url, codeGenerator.generate())
    }

    suspend fun find() = criteria.findAll().asFlow()

    suspend fun mapping(code: String): URLMapperDto {
        val dto = criteria.findByCode(code)
        dto.count = dto.count+1
        if (!dto.isEmpty()) { coroutineScope { async { saver.update(dto) } }}
        val client = ReactorNettyWebSocketClient()
        val uri = URI("ws://localhost:8080/web/socket")
        val res = client.execute(uri) { session ->
            session.send(Mono.just(session.textMessage("now update +1 "))).then()}
        return dto
    }

}
