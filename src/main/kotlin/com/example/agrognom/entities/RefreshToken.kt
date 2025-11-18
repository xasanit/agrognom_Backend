package com.example.agrognom.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

import java.util.Date

@Entity
@Table(name = "refresh_tokens")
class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    var user: User? = null

    @Column(name = "token", nullable = false, length = 500)
    var token: String? = null

    @Column(name = "expiryDate", nullable = false)
    var expiryDate: Date? = null
}
