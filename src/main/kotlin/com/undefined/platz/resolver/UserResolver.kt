package com.undefined.platz.resolver

import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import com.undefined.platz.domain.User
import com.undefined.platz.service.UserService
import org.springframework.stereotype.Component

@Component
class UserQuery(
        private val userService: UserService
) : Query {
    fun user(userId: Long): User? {
        return userService.findOne(userId)
    }

    fun users(): List<User> {
        return userService.findAll()
    }
}

@Component
class UserMutation(
        private val userService: UserService
) : Mutation {
    fun createUser(user: User): Long {
        return userService.join(user)
    }
}

