package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.spring.operations.Mutation
import com.undefined.platz.graphql.model.User
import com.undefined.platz.service.UserService
import org.springframework.stereotype.Component

data class CreateUserInput(
        var email: String,
        val nickname: String,
        val profilePicture: String
)

@Component
class UserMutationResolver(
        private val userService: UserService
) : Mutation {
    fun createUser(input: CreateUserInput): User {
        val user = userService.create(input.email, input.nickname, input.profilePicture)
        return User(user)
    }
}
