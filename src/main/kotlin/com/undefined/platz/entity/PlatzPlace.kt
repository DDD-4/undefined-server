package com.undefined.platz.entity

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class PlatzPlace(
        @ManyToOne
        @JoinColumn(name = "platz_id")
        val platz: Platz,
        @ManyToOne
        @JoinColumn(name = "place_id")
        val place: Place
) : BaseEntity()
