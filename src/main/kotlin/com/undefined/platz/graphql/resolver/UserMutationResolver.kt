package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Mutation
import com.undefined.platz.graphql.model.User
import com.undefined.platz.service.UserService
import org.springframework.stereotype.Component

data class JoinUserInput(
        var email: String,
        val nickname: String,
        val profilePicture: String?
)

data class UpdateUserInput(
        var id: ID,
        var email: String?,
        val nickname: String?,
        val profilePicture: String?
)

data class WithdrawalUserInput(
        var id: ID
)

@Component
class UserMutationResolver(
        private val userService: UserService
) : Mutation {
    fun joinUser(input: JoinUserInput): User {
        val user = userService.create(input.email, input.nickname, input.profilePicture)
        return User(user)
    }

    fun updateUser(input: UpdateUserInput): User {
        val user = userService.update(
                input.id.value.toLong(),
                input.email,
                input.nickname,
                input.profilePicture)
        return User(user)
    }

    fun withdrawalUser(input: WithdrawalUserInput): Boolean {
        return userService.delete(input.id.value.toLong())
    }
}
