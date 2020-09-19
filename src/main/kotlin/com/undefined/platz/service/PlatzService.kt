package com.undefined.platz.service

import com.undefined.platz.entity.Platz
import com.undefined.platz.repository.PlatzRepository
import com.undefined.platz.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PlatzService(
        private val userRepository: UserRepository,
        private val platzRepository: PlatzRepository
) {
    fun findOne(id: Long): Platz? {
        return platzRepository.findByIdOrNull(id)
    }

    fun findAllByUserId(userId: Long): List<Platz> {
        return platzRepository.findAllByUserId(userId)
    }

    fun create(userId: Long, title: String): Platz {
        val user = userRepository.getOne(userId)
        println(user)
        return platzRepository.save(Platz(user, title))
    }

    fun update(id: Long, title: String): Platz {
        val platz = platzRepository.getOne(id)
        platz.title = title
        return platzRepository.save(platz)
    }

    fun delete(id: Long) {
        platzRepository.deleteById(id)
    }
}
