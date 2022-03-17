package me.samoylenko.examples.vulnerable

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.module() {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
    install(Routing) {

        route("/hello") {
            get {
                call.respond("Hello, ${call.request.queryParameters["name"]}")
            }
        }

        route("/view") {
            get {
                val name = call.request.queryParameters["name"] ?: "World"
                call.respond(ThymeleafContent("hello", mapOf("name" to name)))
            }
        }
    }
}
