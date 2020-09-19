package com.undefined.platz.entity

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Platz(
        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,
        var title: String?
        // TODO: Tag 작성시 맵핑 예정
//        @OneToMany(mappedBy = "platz", fetch = FetchType.LAZY)
//        val tags: Set<Tag>? = null,
        // TODO: PlatzLike 작성시 맵핑 예정
//        @OneToMany(mappedBy = "platz")
//        val platzLikes: Set<PlatzLike>? = null,
        // TODO: Place 작성시 맵핑 예정
//        @OneToMany(mappedBy = "platz")
//        val platzPlaces: Set<PlatzPlace>? = null
) : BaseEntity()
