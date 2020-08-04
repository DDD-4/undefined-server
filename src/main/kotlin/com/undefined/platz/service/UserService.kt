package com.undefined.platz.service

import com.undefined.platz.domain.User
import com.undefined.platz.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun findOne(userId: Long): User? {
        return userRepository.findByIdOrNull(userId)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun join(user: User): Long {
        return userRepository.save(user).id!!
    }
}