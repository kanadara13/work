package com.example.work.config

import kotlinx.coroutines.reactor.flux
import org.reactivestreams.Publisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.core.io.buffer.DataBufferFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.*
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Function


@Configuration
class SocketHandlerConfig {

    @Bean
    fun handlerMapping(): HandlerMapping {
        val map = mapOf("/web/socket" to MyWebSocketHandler())
        val order = -1 // before annotated controllers
        return SimpleUrlHandlerMapping(map, order)
    }

    @Bean
    fun handlerAdapter() =  WebSocketHandlerAdapter()
}

@Component
class MyWebSocketHandler : WebSocketHandler {

    override fun handle(session: WebSocketSession): Mono<Void> {
        val message: Flux<WebSocketMessage> = session
                .receive()
                .map { webSocketMessage -> webSocketMessage.payloadAsText }
                .map { text -> session.textMessage(text)}
        return session.send(message)
    }
}