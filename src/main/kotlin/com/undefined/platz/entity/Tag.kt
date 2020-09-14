package com.undefined.platz.entity

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Tag(
        @ManyToOne
        @JoinColumn(name = "platz_id")
        val platz: Platz,
        val tag: String
) : BaseEntity()