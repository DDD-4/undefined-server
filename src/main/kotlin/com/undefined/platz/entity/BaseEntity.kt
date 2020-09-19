package com.undefined.platz.entity

import com.expediagroup.graphql.annotations.GraphQLIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@GraphQLIgnore
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @CreatedDate
        var createdDate: LocalDateTime? = null,

        @LastModifiedDate
        var modifiedDate: LocalDateTime? = null,

        var deletedDate: LocalDateTime? = null
)
