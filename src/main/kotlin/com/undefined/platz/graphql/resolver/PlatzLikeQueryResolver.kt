package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Query
import com.undefined.platz.service.PlatzLikeService
import org.springframework.stereotype.Component

@Component
class PlatzLikeQueryResolver(
        private val PlatzLikeService: PlatzLikeService
) : Query {
    fun isLikesPlatz(platzId: ID, userId: ID): Boolean {
        return PlatzLikeService.exists(platzId.value.toLong(), userId.value.toLong())
    }
}
