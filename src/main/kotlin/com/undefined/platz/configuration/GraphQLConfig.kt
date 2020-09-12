package com.undefined.platz.configuration

import com.expediagroup.graphql.hooks.SchemaGeneratorHooks
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import graphql.schema.GraphQLType
import org.springframework.context.annotation.Configuration
import java.sql.Timestamp
import java.time.LocalDateTime
import kotlin.reflect.KType

@Configuration
class CustomScalarGeneratorHooks : SchemaGeneratorHooks {
    override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier) {
        LocalDateTime::class -> graphqlDateTimeType
        else -> null
    }
}

internal val graphqlDateTimeType = GraphQLScalarType.newScalar()
        .name("DateTime")
        .description("java.time.LocalDateTime")
        .coercing(object : Coercing<LocalDateTime, String> {
            override fun parseLiteral(input: Any): LocalDateTime = LocalDateTime.parse(input as String)
            override fun parseValue(input: Any): LocalDateTime = parseLiteral(input)
            override fun serialize(dataFetcherResult: Any): String = Timestamp.valueOf(dataFetcherResult as LocalDateTime).time.toString()
        })
        .build()