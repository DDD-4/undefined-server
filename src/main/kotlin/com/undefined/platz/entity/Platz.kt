package com.undefined.platz.entity

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Platz(
        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,
        val title: String?,
        @OneToMany(mappedBy = "platz")
        val tags: Set<Tag>,
        @OneToMany(mappedBy = "platz")
        val platzLikes: Set<PlatzLike>,
        @OneToMany(mappedBy = "platz")
        val platzPlaces: Set<PlatzPlace>
) : BaseEntity()