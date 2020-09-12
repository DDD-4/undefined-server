package com.undefined.platz

import com.undefined.platz.configuration.ApplicationConfigurationProperties
import com.undefined.platz.configuration.ParameterStoreConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableConfigurationProperties(ParameterStoreConfigurationProperties::class, ApplicationConfigurationProperties::class)
@SpringBootApplication
@EnableJpaAuditing
class PlatzApplication

fun main(args: Array<String>) {
    runApplication<PlatzApplication>(*args)
}
