package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Query
import com.undefined.platz.graphql.model.Platz
import com.undefined.platz.service.PlatzService
import org.springframework.stereotype.Component

@Component
class PlatzQuery(
        private val PlatzService: PlatzService
) : Query {
    fun platz(id: ID): Platz? {
        val platz = PlatzService.findOne(id.value.toLong()) ?: return null
        return Platz(platz)
    }

    fun platzs(userId: ID): List<Platz> {
        return PlatzService.findAllByUserId(userId.value.toLong()).map { Platz(it) }
    }
}
