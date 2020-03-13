package com.example.work.config

import kotlinx.coroutines.flow.Flow
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import reactor.core.publisher.Flux
import reactor.core.publisher.Flux.interval
import reactor.core.publisher.Mono
import java.lang.String
import java.time.Duration


@Configuration
class SocketHandlerConfig(private val webSocketHandler: WebSocketHandler) {

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
        return session.send(
                interval(Duration.ofSeconds(1))
                        .map{ l -> String.format("{ \"Message\": %s }", l) }
                        .map(session::textMessage)) // map to Spring WebSocketMessage of type text

    }
}