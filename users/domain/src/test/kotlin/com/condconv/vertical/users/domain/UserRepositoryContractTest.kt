package com.condconv.vertical.users.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

abstract class UserRepositoryContractTest {

    abstract fun userRepository(): UserRepository

    private lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        userRepository = userRepository()
    }

    @Test
    fun `it creates and saves a new user`() {
        val user = userRepository.create(
            firstName = "first name",
            lastName = "last name",
            email = "first.last@email.com"
        )

        assertThat(user).isEqualToIgnoringGivenFields(
            User(
                firstName = "first name",
                lastName = "last name",
                email = "first.last@email.com"
            ),
            "id"
        )
    }

}