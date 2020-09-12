package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import com.undefined.platz.graphql.model.User
import com.undefined.platz.service.UserService
import org.springframework.stereotype.Component

@Component
class UserQuery(
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

data class CreateUserInput(
        var email: String,
        val nickname: String,
        val profilePicture: String
)

@Component
class UserMutation(
        private val userService: UserService
) : Mutation {
    fun createUser(input: CreateUserInput): User {
        val user = userService.create(input.email, input.nickname, input.profilePicture)
        return User(user)
    }
}