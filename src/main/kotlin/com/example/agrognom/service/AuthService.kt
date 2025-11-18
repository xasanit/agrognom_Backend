package com.example.agrognom.service

import com.example.agrognom.auth.JwtService
import com.example.agrognom.dto.TokenResponse
import com.example.agrognom.entities.User
import com.example.agrognom.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder,
    private val refreshTokenService: RefreshTokenService
) {

    fun generateTokens(user: User): TokenResponse {

        val access = jwtService.generateAccessToken(user.username)
        val refresh = jwtService.generateRefreshToken(user.username)

        refreshTokenService.createOrUpdate(
            user = user,
            token = refresh,
            expiryDate = jwtService.getRefreshExpiryDate()
        )

        return TokenResponse(
            accessToken = access,
            refreshToken = refresh
        )
    }


    fun register(username: String, password: String, email: String?): TokenResponse {

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

        return generateTokens(user)
    }


    fun login(username: String, password: String): TokenResponse {

        val user = userRepository.findByUsername(username)
            ?: throw RuntimeException("User does not exist")

        if (!passwordEncoder.matches(password, user.password)) {
            throw RuntimeException("Invalid password")
        }

        return generateTokens(user)
    }


    fun refresh(refreshToken: String): TokenResponse {

        val user = refreshTokenService.validate(refreshToken)
            ?: throw RuntimeException("Invalid refresh token")

        return generateTokens(user)
    }
}