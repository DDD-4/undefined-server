package com.undefined.platz.entity

import javax.persistence.Entity

@Entity
data class User(
        var email: String,
        var profilePicture: String?,
        var nickname: String
) : BaseEntity()
