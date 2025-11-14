package com.example.agrognom.service

import com.example.agrognom.auth.JwtService
import com.example.agrognom.entities.User
import com.example.agrognom.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder,
) {

    fun register(username: String, password: String, email: String?): String {

        if (userRepository.existsByUsername(username)) {
            throw RuntimeException("User already exists")
        }

        if (email != null && userRepository.existsByEmail(email)) {
            throw RuntimeException("Email already registered!")
        }

        val user = User().apply {
            this.username = username
            this.password = passwordEncoder.encode(password)
            this.email = email
        }

        userRepository.save(user)

        return jwtService.generateToken(username)
    }

    fun login(username: String, password: String): String {

        val user = userRepository.findByUsername(username) ?: throw RuntimeException("User does not exist")

        if (!passwordEncoder.matches(password, user.password)) {
            throw RuntimeException("Invalid password")
        }

        return jwtService.generateToken(user.username)
    }
}