package com.undefined.platz.repository

import com.undefined.platz.entity.PlatzLike
import org.springframework.data.jpa.repository.JpaRepository

interface PlatzLikeRepository : JpaRepository<PlatzLike, Long> {
    fun existsByPlatzIdAndUserId(platzId: Long, userId: Long): Boolean
    fun deleteByPlatzIdAndUserId(platzId: Long, userId: Long)
}
