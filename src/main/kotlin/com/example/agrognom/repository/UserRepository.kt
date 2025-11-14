package com.example.agrognom.repository

import com.example.agrognom.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?

    fun existsByEmail(email: String?): Boolean

    fun existsByUsername(username: String): Boolean
}