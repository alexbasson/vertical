package com.condconv.vertical.users.persistence

import com.condconv.vertical.users.domain.UserRepository
import com.condconv.vertical.users.domain.UserRepositoryContractTest

class InMemoryUserRepositoryContractTest: UserRepositoryContractTest() {

    override fun userRepository(): UserRepository {
        return InMemoryUserRepository()
    }

}