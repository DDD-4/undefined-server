package com.undefined.platz.graphql.model

import com.expediagroup.graphql.scalars.ID
import com.undefined.platz.entity.Platz

data class Platz(
        val id: ID?,
        val user: User,
        var title: String?
) {
    constructor(entity: Platz) : this(
            id = ID(entity.id.toString()),
            user = User(entity.user),
            title = entity.title
    )
}
