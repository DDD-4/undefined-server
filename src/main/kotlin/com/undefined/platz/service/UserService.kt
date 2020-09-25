package com.undefined.platz.service

import com.undefined.platz.entity.User
import com.undefined.platz.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

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

    fun create(email: String, nickname: String, profilePicture: String?): User {
        return userRepository.save(User(
                email,
                profilePicture,
                nickname)
        )
    }

    fun update(id: Long, email: String?, nickname: String?, profilePicture: String?): User {
        val user = userRepository.getOne(id)
        if (email != null) {
            user.email = email
        }
        if (nickname != null) {
            user.nickname = nickname
        }
        if (profilePicture != null) {
            user.profilePicture = profilePicture
        }

        return userRepository.save(user)
    }

    fun delete(id: Long): Boolean {
        val user = userRepository.getOne(id)
        user.deletedDate = LocalDateTime.now()
        userRepository.save(user)

        return true
    }
}
