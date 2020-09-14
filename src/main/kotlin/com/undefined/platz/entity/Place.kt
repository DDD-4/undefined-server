package com.undefined.platz.entity

import javax.persistence.Entity
import javax.persistence.OneToMany


@Entity
data class Place(
        val kakaoPlaceId: String,
        val title: String,
        val latitude: Double,
        val longitude: Double,
        @OneToMany(mappedBy = "place")
        val platzs: Set<PlatzPlace>
) : BaseEntity()