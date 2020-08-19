package com.undefined.platz.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring")
data class ApplicationConfigurationProperties(
        var profiles: String = ""
)
