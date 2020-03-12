package com.example.work.config

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import java.time.Instant




class RSocketHandler : WebSocketHandler {

    override fun handle(session: WebSocketSession): Mono<Void> {
        TODO("Not yet implemented")
    }

/*    @MessageMapping("update")
    fun greet(message : String): Mono<Notification> {
        return Mono.just(Notification().apply { this.message = "Hello $message ${Instant.now()}"})
    }*/
}