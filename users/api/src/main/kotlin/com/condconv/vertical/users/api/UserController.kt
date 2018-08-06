package com.condconv.vertical.users.api

import com.condconv.vertical.users.domain.User
import com.condconv.vertical.users.domain.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/users")
class UserController(
    private val userRepository: UserRepository
) {

    @GetMapping()
    fun index(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userRepository.findAll())
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(userRepository.findById(id))
    }

    @PostMapping()
    fun create(@RequestBody request: CreateUserRequest): ResponseEntity<User> {
        return ResponseEntity(userRepository.create(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email
        ), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(userRepository.update(id, user))
    }

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: Long): ResponseEntity<Void> {
        userRepository.delete(id = id)
        return ResponseEntity(HttpStatus.OK)
    }

    data class CreateUserRequest(
        val firstName: String,
        val lastName: String,
        val email: String
    )

}