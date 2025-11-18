package com.example.agrognom.entities

import jakarta.persistence.*

@Entity
@Table(name = "crops")
class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 100)
    open var name: String? = null
}