package com.condconv.vertical.users.domain

interface UserRepository {
    fun create(firstName: String, lastName: String, email: String): User

    fun findAll(): List<User>
    fun findById(id: Long): User
    fun findByFirstName(firstName: String): List<User>
    fun findByEmail(email: String): User?

    fun update(id: Long, user: User): User

    fun delete(id: Long)
}
