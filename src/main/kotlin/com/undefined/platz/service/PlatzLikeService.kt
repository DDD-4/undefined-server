package com.undefined.platz.service

import com.undefined.platz.entity.PlatzLike
import com.undefined.platz.repository.PlatzLikeRepository
import com.undefined.platz.repository.PlatzRepository
import com.undefined.platz.repository.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PlatzLikeService(
        private val userRepository: UserRepository,
        private val platzRepository: PlatzRepository,
        private val platzLikeRepository: PlatzLikeRepository
) {
    fun exists(platzId: Long, userId: Long): Boolean {
        return platzLikeRepository.existsByPlatzIdAndUserId(platzId, userId)
    }

    fun create(platzId: Long, userId: Long) {
        val platz = platzRepository.getOne(platzId)
        val user = userRepository.getOne(userId)
        platzLikeRepository.save(PlatzLike(user, platz))
    }

    @Transactional
    fun delete(platzId: Long, userId: Long) {
        platzLikeRepository.deleteByPlatzIdAndUserId(platzId, userId)
    }
}
