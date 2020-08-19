package com.undefined.platz

import com.undefined.platz.configuration.ApplicationConfigurationProperties
import com.undefined.platz.configuration.ParameterStoreConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(ParameterStoreConfigurationProperties::class, ApplicationConfigurationProperties::class)
@SpringBootApplication
class PlatzApplication

fun main(args: Array<String>) {
    runApplication<PlatzApplication>(*args)
}
