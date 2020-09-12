package com.undefined.platz.graphql.model

import com.expediagroup.graphql.scalars.ID
import com.undefined.platz.entity.User

data class User(
        var id: ID?,
        var email: String,
        val profilePicture: String?,
        val nickname: String
) {
    constructor(entity: User) : this(
            id = ID(entity.id.toString()),
            email = entity.email,
            profilePicture = entity.profilePicture,
            nickname = entity.nickname
    )
}