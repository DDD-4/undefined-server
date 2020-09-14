package com.undefined.platz.entity

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class PlatzLike(
        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,
        @ManyToOne
        @JoinColumn(name = "platz_id")
        val platz: Platz?
) : BaseEntity()