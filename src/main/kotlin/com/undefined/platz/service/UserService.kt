package com.undefined.platz.service

import com.undefined.platz.entity.User
import com.undefined.platz.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun findOne(id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun create(email: String, nickname: String, profilePicture: String): User {
        return userRepository.save(User(
                email,
                nickname,
                profilePicture))
    }
}
