package com.condconv.vertical.users.persistence

import com.condconv.vertical.users.domain.User
import com.condconv.vertical.users.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class InMemoryUserRepository: UserRepository {

    private val users = ArrayList<User>()

    override fun create(firstName: String, lastName: String, email: String): User {
        val user = User(
            id = (users.lastOrNull()?.id ?: 0L).plus(1L),
            firstName = firstName,
            lastName = lastName,
            email = email
        )
        users.add(user)
        return user
    }

    override fun findAll(): List<User> {
        return users
    }

    override fun findById(id: Long): User {
        return users.find { it.id == id } ?: throw Exception()
    }

    override fun findByFirstName(firstName: String): List<User> {
        return users.filter { it.firstName == firstName }
    }

    override fun findByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    override fun update(id: Long, user: User): User {
        val index = users.indexOfFirst { it.id == id }
        if (index < 0) throw Exception()
        users[index] = user
        return findById(id)
    }

    override fun delete(id: Long) {
        users.removeIf { it.id == id }
    }
}