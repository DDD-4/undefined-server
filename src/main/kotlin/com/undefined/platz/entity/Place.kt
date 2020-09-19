package com.undefined.platz.entity

import javax.persistence.Entity


@Entity
data class Place(
        val kakaoPlaceId: String,
        val title: String,
        val latitude: Double,
        val longitude: Double
        // TODO: Place 작성시 맵핑 예정
//        @OneToMany(mappedBy = "place")
//        val platzs: Set<PlatzPlace>
) : BaseEntity()
