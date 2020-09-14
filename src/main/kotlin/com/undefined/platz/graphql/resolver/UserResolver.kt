package com.undefined.platz.graphql.resolver

import com.expediagroup.graphql.scalars.ID
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import com.undefined.platz.graphql.model.UserModel
import com.undefined.platz.service.UserService
import org.springframework.stereotype.Component

@Component
class UserQuery(
        private val userService: UserService
) : Query {
    fun user(id: ID): UserModel? {
        val user = userService.findOne(id.value.toLong()) ?: return null
        return UserModel(user)
    }

    fun users(): List<UserModel> {
        return userService.findAll().map { UserModel(it) }
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
    fun createUser(input: CreateUserInput): UserModel {
        val user = userService.create(input.email, input.nickname, input.profilePicture)
        return UserModel(user)
    }
}