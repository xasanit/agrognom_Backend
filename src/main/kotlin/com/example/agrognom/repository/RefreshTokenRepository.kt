package com.example.agrognom.repository

import com.example.agrognom.entities.RefreshToken
import com.example.agrognom.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository : JpaRepository<RefreshToken, Long> {

    fun findByToken(token: String): RefreshToken?

    fun findByUser(user: User): RefreshToken?

}
