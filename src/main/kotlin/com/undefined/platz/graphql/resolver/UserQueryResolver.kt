package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Query
import com.undefined.platz.graphql.model.User
import com.undefined.platz.service.UserService
import org.springframework.stereotype.Component

@Component
class UserQueryResolver(
        private val userService: UserService
) : Query {
    fun user(id: ID): User? {
        val user = userService.findOne(id.value.toLong()) ?: return null
        return User(user)
    }

    fun users(): List<User> {
        return userService.findAll().map { User(it) }
    }
}
