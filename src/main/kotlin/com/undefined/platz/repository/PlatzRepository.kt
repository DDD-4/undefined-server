package com.undefined.platz.repository

import com.undefined.platz.entity.Platz
import org.springframework.data.jpa.repository.JpaRepository

interface PlatzRepository : JpaRepository<Platz, Long> {
    fun findAllByUserId(userId: Long): List<Platz>
}
