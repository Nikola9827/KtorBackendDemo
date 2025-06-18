package com.example.backend

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.delay
import java.time.LocalDateTime

fun main() {
    embeddedServer(factory = Netty, port = 8080, host = "0.0.0.0"){
        module()
    }.start(true)
}

fun Application.module() {
    install(ContentNegotiation){
        json()
    }
    routing {
        get("/helloworld"){
            val currentTime = LocalDateTime.now()
            delay(5000)
            call.respond(HelloResponse("backend $currentTime"))
        }
    }
}