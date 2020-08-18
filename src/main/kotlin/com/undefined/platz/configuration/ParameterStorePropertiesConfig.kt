package com.undefined.platz.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class ParameterStorePropertiesConfig {
    @Value("\${db.host}")
    lateinit var dbHost: String

    @Value("\${db.name}")
    lateinit var dbUserName: String

    @Value("\${db.password}")
    lateinit var dbPassword: String
}
