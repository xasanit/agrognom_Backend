package com.example.agrognom.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService (
    @Value("\${jwt.secret}") private val secret: String     //класс для генерации токенов
) {
    private val secretKey = Keys.hmacShaKeyFor(secret.toByteArray())

    private val ACCESS_EXP = 1000 * 60 * 15          // 15 минут
    private val REFRESH_EXP = 1000L * 60 * 60 * 24 * 30 // 30 дней

    fun generateAccessToken(username: String?): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + ACCESS_EXP)) // 15 минут
            .signWith(secretKey)
            .compact()
    }

    fun generateRefreshToken(username: String?): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + REFRESH_EXP)) // 30 дней
            .signWith(secretKey)
            .compact()
    }

    fun getRefreshExpiryDate(): Date =
        Date(System.currentTimeMillis() + REFRESH_EXP)

    fun extractUsername(token: String): String? {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .body
                .subject
        } catch (e: Exception) {
            null
        }
    }
}