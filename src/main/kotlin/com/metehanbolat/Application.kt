package com.metehanbolat

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable

fun main(){
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation){
            json()
        }
        module()
    }.start(wait = true)
}

fun Application.module() {
    install(Routing) {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/users/{username}") {
            val userName = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (userName == "Admin"){
                call.response.header(name = "CustomHeader", "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }
            call.respondText("Greetings, $userName with header: $header")
        }
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
            call.respondText("Hi, my name is $name, I'm $age years old!")
        }
        get("/person") {
            val person = Person(name = "John", age = 26)
            call.respond(message = person, status = HttpStatusCode.OK)
        }
        get("/redirect") {
            call.respondRedirect(url = "/moved", permanent = false)
        }
        get("/moved") {
            call.respondText("You have been successfully redirected!")
        }
    }
}

@Serializable
data class Person(
    val name: String,
    val age: Int
)