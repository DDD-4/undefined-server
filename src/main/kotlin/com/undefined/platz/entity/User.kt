package com.undefined.platz.entity

import javax.persistence.Entity

@Entity
data class User(
        val email: String,
        val profilePicture: String?,
        val nickname: String
) : BaseEntity()
