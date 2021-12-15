package com.metehanbolat

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(){
    embeddedServer(Netty, port = 8080) {
        module()
        module2()
    }.start(wait = true)
}

fun Application.module(){
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}

fun Application.module2(){
    routing {
        get("/book") {
            call.respondText("Hello World 2!")
        }
    }
}