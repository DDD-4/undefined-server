package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Mutation
import com.undefined.platz.service.PlatzLikeService
import org.springframework.stereotype.Component

data class LikePlatzInput(
        val platzId: ID,
        val userId: ID
)

data class UnlikePlatzInput(
        val platzId: ID,
        val userId: ID
)

@Component
class PlatzLikeMutationResolver(
        private val PlatzLikeService: PlatzLikeService
) : Mutation {
    fun likePlatz(input: LikePlatzInput): Boolean {
        PlatzLikeService.create(input.platzId.value.toLong(), input.userId.value.toLong())
        return true
    }

    fun unlikePlatz(input: UnlikePlatzInput): Boolean {
        PlatzLikeService.delete(input.platzId.value.toLong(), input.userId.value.toLong())
        return true
    }
}
