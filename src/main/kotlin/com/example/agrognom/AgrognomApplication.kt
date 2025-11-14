package com.example.agrognom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AgrognomApplication

fun main(args: Array<String>) {
	runApplication<AgrognomApplication>(*args)
}
