package com.condconv.vertical.users.domain

data class User(
    val id: Long = 0L,
    val firstName: String,
    val lastName: String,
    val email: String
)
