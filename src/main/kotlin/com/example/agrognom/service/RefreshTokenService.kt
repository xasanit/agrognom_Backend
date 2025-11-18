package com.example.agrognom.service

import com.example.agrognom.entities.RefreshToken
import com.example.agrognom.entities.User
import com.example.agrognom.repository.RefreshTokenRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RefreshTokenService(
    private val refreshTokenRepository: RefreshTokenRepository,
) {

    fun createOrUpdate(user: User, token: String, expiryDate: Date): RefreshToken {
        val existing = refreshTokenRepository.findByUser(user)

        if (existing != null) {
            existing.token = token
            existing.expiryDate = expiryDate
            return refreshTokenRepository.save(existing)
        }

        val newToken = RefreshToken().apply {
            this.user = user
            this.token = token
            this.expiryDate = expiryDate
        }


        return refreshTokenRepository.save(newToken)
    }

    fun validate(token: String): User? {
        val refresh = refreshTokenRepository.findByToken(token) ?: return null

        if (refresh.expiryDate?.before(Date()) == true) {
            return null
        }

        return refresh.user
    }
}