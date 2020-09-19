package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Mutation
import com.undefined.platz.graphql.model.Platz
import com.undefined.platz.service.PlatzService
import org.springframework.stereotype.Component

data class CreatePlatzInput(
        val userId: ID,
        var title: String
)

data class UpdatePlatzInput(
        val platzId: ID,
        var title: String
)

data class DeletePlatzInput(
        val platzId: ID
)

@Component
class PlatzMutation(
        private val PlatzService: PlatzService
) : Mutation {
    fun createPlatz(input: CreatePlatzInput): Platz {
        val platz = PlatzService.create(input.userId.value.toLong(), input.title)
        return Platz(platz)
    }

    fun updatePlatz(input: UpdatePlatzInput): Platz {
        val platz = PlatzService.update(input.platzId.value.toLong(), input.title)
        return Platz(platz)
    }

    fun deletePlatz(input: DeletePlatzInput): Boolean {
        PlatzService.delete(input.platzId.value.toLong())
        // TODO: 어떤 기준으로 boolean 값을 전달할지 정해야 함
        return true
    }
}
