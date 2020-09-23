package com.undefined.platz.entity

import javax.persistence.*

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "platz_id"])])
data class PlatzLike(
        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,
        @ManyToOne
        @JoinColumn(name = "platz_id")
        val platz: Platz?
) : BaseEntity()
