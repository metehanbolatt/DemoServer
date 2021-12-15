package com.metehanbolat

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.h3
import kotlinx.html.head
import kotlinx.html.title

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    install(CallLogging)
    routing {
        static {
            resources("static")
        }
        get("/") {
            call.respondText("Hello World")
        }
        get("/welcome") {
            call.respondHtml {
                head {
                    title { +"Custom Title"}
                }
                body {
                    h3 { +"Welcome" }
                }
            }
        }
    }
}