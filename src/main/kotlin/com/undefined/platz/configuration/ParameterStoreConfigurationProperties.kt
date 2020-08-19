package com.undefined.platz.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "db")
data class ParameterStoreConfigurationProperties(
        var host: String = "",
        var port: String = "",
        var name: String = "",
        var password: String = ""
)
