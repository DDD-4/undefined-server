package com.undefined.platz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlatzApplication

fun main(args: Array<String>) {
	runApplication<PlatzApplication>(*args)
}
